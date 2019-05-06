package com.holubinka.controller;

import com.holubinka.controller.external.model.UserRegistration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Throwable.class)
    public String globalHandler(Exception e){
        return "error";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ModelAndView useAlreadyExist(Exception e) {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("register");
        vm.addObject("error", "Username already exist");
        vm.addObject("userRegistration", new UserRegistration());
        return vm;
    }
}
