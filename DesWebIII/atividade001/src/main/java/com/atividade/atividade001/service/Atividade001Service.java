package com.atividade.atividade001.service;

import org.springframework.stereotype.Service;

@Service
public class Atividade001Service {

    public String heloWorld(String name) {
        return "Hello world, " + name;
    }
}