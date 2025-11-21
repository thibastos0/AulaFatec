package com.example.demo_testes_pratica.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public int somar(int a, int b){
        return a + b;
    }

    public int dividir (int a, int b){
        if (b == 0) {
            throw new ArithmeticException("Não é possível divisão por zero!");
        }
        return a / b;
    }

    public int subtrair(int a, int b){
        return a - b;
    }

}
