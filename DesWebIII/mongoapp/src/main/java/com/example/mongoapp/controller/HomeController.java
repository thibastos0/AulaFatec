package com.example.mongoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/mongoapp/user")
    public String userPage() {
        return "mongoapp/user";
    }

    @GetMapping("/mongoapp/product")
    public String productPage() {
        return "mongoapp/product";
    }
    

}