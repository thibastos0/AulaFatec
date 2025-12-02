package com.example.teste_unitario.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculadoraDescontoTest {

    @Test
    void deveAplicarDescontoCorretamente() {

        //Arrange
        CalculadoraDesconto calc = new CalculadoraDesconto();

        //Act
        double resultado = calc.calculadoraDesconto(1000, 10);

        //Assert
        assertEquals(900, resultado);

    }

    @Test
    void deveLancarExcessaoValorNegativo() {

        //Arrange
        CalculadoraDesconto calc = new CalculadoraDesconto();

        assertThrows(IllegalArgumentException.class, () -> {
            calc.calculadoraDesconto(-1000, 10);
        });

    }

}
