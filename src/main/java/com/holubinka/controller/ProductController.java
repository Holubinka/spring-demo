package com.holubinka.controller;

import com.holubinka.model.Product;
import com.holubinka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView getById(@RequestParam("p_id") Long id, ModelAndView vm) {
        vm.setViewName("product");
        vm.addObject("product", productService.getById(id));
        return vm;
    }

    @RequestMapping(value = "/reduce", method = RequestMethod.GET)
    public ModelAndView increase(@RequestParam("p_id") Long id, ModelAndView vm) {
        Product product = productService.getById(id);
        vm.setViewName("product");
        vm.addObject("product", productService.reducePriceByPercents(product,10));
        return vm;
    }
}
