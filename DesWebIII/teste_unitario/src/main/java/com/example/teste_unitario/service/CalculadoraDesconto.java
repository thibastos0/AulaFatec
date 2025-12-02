package com.example.teste_unitario.service;

public class CalculadoraDesconto {



    public double calculadoraDesconto(double valor, double percentual) {

        if(valor < 0 || percentual < 0) {
            throw new IllegalArgumentException("Valor ou percentual nao podem ser negativos");
        }

        return valor - (valor*percentual/100);

    }

}
