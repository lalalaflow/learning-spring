package dev.helloworld.springmvc.servlet.web.frontcontoller.v3;

import dev.helloworld.springmvc.servlet.web.frontcontoller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);

}
