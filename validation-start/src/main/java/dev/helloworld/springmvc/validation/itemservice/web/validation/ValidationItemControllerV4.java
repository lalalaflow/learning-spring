package dev.helloworld.springmvc.validation.itemservice.web.validation;

import dev.helloworld.springmvc.validation.itemservice.domain.item.Item;
import dev.helloworld.springmvc.validation.itemservice.domain.item.ItemRepository;
import dev.helloworld.springmvc.validation.itemservice.domain.item.SaveCheck;
import dev.helloworld.springmvc.validation.itemservice.domain.item.UpdateCheck;
import dev.helloworld.springmvc.validation.itemservice.web.validation.form.ItemSaveForm;
import dev.helloworld.springmvc.validation.itemservice.web.validation.form.ItemUpdateForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/validation/v4/items")
@RequiredArgsConstructor
public class ValidationItemControllerV4 {

    private final ItemRepository itemRepository;


    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "validation/v4/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v4/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "validation/v4/addForm";
    }

    @PostMapping("/add")
    public String addItem(@Validated @ModelAttribute("item") ItemSaveForm form, BindingResult bindingResult
            , RedirectAttributes redirectAttributes, Model model){

        log.info("objectName={}", bindingResult.getObjectName());
        log.info("target={}", bindingResult.getTarget());

        //특정 필드가 아닌 복합 룰 검증
        if(form.getPrice() != null && form.getQuantity() != null) {
            int resultPrice = form.getPrice() * form.getQuantity();
            if(resultPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }

        //검증에 실패하면 다시 입력 품으로
        if(bindingResult.hasErrors()){
            log.info("errors = {}", bindingResult);
            return "validation/v4/addForm";
        }

        Item itemParam = new Item();
        itemParam.setItemName(form.getItemName());
        itemParam.setPrice(form.getPrice());
        itemParam.setQuantity(form.getQuantity());

        //성공로직ㄹ
        Item savedItem = itemRepository.save(itemParam);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v4/items/{itemId}";
    }


    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v4/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @Validated @ModelAttribute("item") ItemUpdateForm form, BindingResult bindingResult) {

        if(form.getPrice() != null && form.getQuantity() != null) {
            int resultPrice = form.getPrice() * form.getQuantity();
            if(resultPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }

        if(bindingResult.hasErrors()){
            log.info("errors = {}", bindingResult);
            return "validation/v4/editForm";
        }

        Item itemParam = new Item();
        itemParam.setId(form.getId());
        itemParam.setItemName(form.getItemName());
        itemParam.setPrice(form.getPrice());
        itemParam.setQuantity(form.getQuantity());

        itemRepository.update(itemId, itemParam);
        return "redirect:/validation/v4/items/{itemId}";
    }



}

