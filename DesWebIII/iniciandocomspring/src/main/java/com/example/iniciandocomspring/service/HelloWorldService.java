package com.example.iniciandocomspring.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String helloWorld(String nome, String email) {
        return "Hello World, " + nome + "! Your email is " + email + ".";
    }

}
