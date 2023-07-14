package dev.helloworld.springmvc.exception.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Slf4j
@Controller
public class ServletExController {

    @GetMapping ("/error-404")
    public void exception404(HttpServletResponse response) throws IOException{
        response.sendError(404, "404 오류 !");
    }

    @GetMapping ("/error-500")
    public void exception500(HttpServletResponse response) throws IOException{
        response.sendError(500);
    }

    @GetMapping ("/error-ex")
    public void exceptionEX(HttpServletResponse response) throws IOException{
        log.info("error EX to 500");
        response.sendError(500, "500 오류 !");
    }


}
