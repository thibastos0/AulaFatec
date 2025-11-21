package com.example.testeunitario.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculadoraDeDescontoTest {

    @Test
    void deveAplicarDescontoCorretamente_case1() {
        //Arrange
        CalculadoraDeDesconto calc = new CalculadoraDeDesconto();

        //Act
        double resultado = calc.aplicarDesconto(200.0, 25.0);

        //Assert
        assertEquals(150.0, resultado, 0.001);

    }

    @Test
    void deveLancarExcecaoQuandoValoresNegativos_case2(){
        //Arrange
        CalculadoraDeDesconto calc = new CalculadoraDeDesconto();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, ()-> {calc.aplicarDesconto(-100.0, 10.0);});
    }

}
