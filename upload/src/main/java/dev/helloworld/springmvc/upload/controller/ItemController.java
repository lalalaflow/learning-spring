package dev.helloworld.springmvc.upload.controller;

import dev.helloworld.springmvc.upload.domain.Item;
import dev.helloworld.springmvc.upload.domain.ItemRepository;
import dev.helloworld.springmvc.upload.domain.UploadFile;
import dev.helloworld.springmvc.upload.file.FileStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController  {

    private final ItemRepository itemRepository;
    private final FileStore fileStore;

    @GetMapping("/items/new")
    public String newItem(@ModelAttribute ItemForm form) {
        return "item-form";
    }

    @PostMapping("/items/new")
    public String saveItem(@ModelAttribute ItemForm form, RedirectAttributes redirectAttributes) throws IOException {
        UploadFile uploadFile = fileStore.storeFile(form.getAttachFile());
        List<UploadFile> storeImageFiles = fileStore.sotreFiles(form.getImageFiles());
        // 데이터베이스에 저장
        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setAttachFile(uploadFile);
        item.setImageFiles(storeImageFiles);
        itemRepository.saveItem(item);

        redirectAttributes.addAttribute("itemId", item.getId());
        return "redirect:/items/{itemId}";

    }

    @GetMapping("/items/{id}")
    public String items(@PathVariable Long id, Model model) {
        Item item = itemRepository.findItem(id);
        model.addAttribute("item", item);
        return "item-view";
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }

    @GetMapping("/attach/{itemId}")
    public ResponseEntity<Resource> downloadAttach(@PathVariable Long itemId) throws MalformedURLException {
         Item item = itemRepository.findItem(itemId);
         String storeFileName = item.getAttachFile().getStoreFileName();
         String uploadFileName = item.getAttachFile().getUploadFileName();

         UrlResource resource = new UrlResource("file:"+ fileStore.getFullPath(storeFileName));
         log.info("uploadFileName={}", uploadFileName);

         String encodedUploadFileName = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8);
         String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\"";
         return ResponseEntity.ok()
                 .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                 .body(resource);
    }
}
