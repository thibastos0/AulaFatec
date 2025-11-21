package com.example.demo_testes_pratica.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculadoraServiceTest {

    private final CalculadoraService calc = new CalculadoraService();

    @Test
    void testeDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> {calc.dividir(10,0);});

    }

    @Test
    void testeSomaCorretamente() {
        
        //Act
        int resultado = calc.somar(2, 2);

        //Assert
        assertEquals(4, resultado);

    }

    @Test
    void testeSubtrairCorretamente() {

        //Act
        int resultado = calc.subtrair(4, 3);

        //Assert
        assertEquals(1, resultado);
    }

}
