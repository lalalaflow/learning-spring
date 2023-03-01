package dev.helloworld.springmvc.servlet.web.frontcontoller.v5;

import dev.helloworld.springmvc.servlet.web.frontcontoller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.server.ServerCloneException;

public interface MyHandlerAdapter {

    boolean support(Object handler);
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
