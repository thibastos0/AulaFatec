package com.example.iniciandocomspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iniciandocomspring.domain.User;
import com.example.iniciandocomspring.service.HelloWorldService;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

    @Autowired //Injeção de dependência automática, substituindo o construtor
    private HelloWorldService helloWorldService;

 /*   public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }*/

    @GetMapping
    public String helloWorld() {
        //return "Hello, World!";
        return helloWorldService.helloWorld("Thiago", "thiago@email.com");
    }
    
    @PostMapping("")
    public String helloWorldPost(@RequestBody User body) {  
        return helloWorldService.helloWorld(body.getName(), body.getEmail());
    }

}