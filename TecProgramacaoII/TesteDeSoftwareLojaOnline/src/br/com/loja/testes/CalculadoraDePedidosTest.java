package br.com.loja.testes;

import org.junit.jupiter.api.Test;
import br.com.loja.CalculadoraDePedidos;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDePedidosTest {

    @Test
    void DeveCalcularValorTotalComDescontoCorretamente(){
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();
        
        //Act
        double resultado = calculadoraDePedidos.calcularTotal(500.00, 2, 10.0);

        //Assert
        assertEquals(900.0, resultado);
    }

    @Test
    void DeveRetornarExcecaoParaPrecoNegativo() {
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();

        //Assert & Act
        assertThrows(IllegalArgumentException.class, () -> calculadoraDePedidos.calcularTotal(-500.00, 2, 10.0));

    }

    @Test
    void DeveRetornarExcecaoParaQuantidadeNegativo() {
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();

        //Assert & Act
        assertThrows(IllegalArgumentException.class, () -> calculadoraDePedidos.calcularTotal(500.00, -2, 10.0));

    }

    @Test
    void DeveRetornarExcecaoParaDoisValoresNegativos() {
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();

        //Assert & Act
        assertThrows(IllegalArgumentException.class, () -> calculadoraDePedidos.calcularTotal(-500.00, -2, 10.0));

    }

    @Test
    void DeveRetornarExcecaoParaDescontoNegativo() {
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();

        //Assert & Act
        assertThrows(IllegalArgumentException.class, () -> calculadoraDePedidos.calcularTotal(500.00, 2, -10.0));

    }

    @Test
    void DeveRetornarValorZeroComQuantidadeZero() {
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();

        //Act
        double resultado = calculadoraDePedidos.calcularTotal(500.00, 0, 10.0);

        //Assert
        assertEquals(0, resultado);

    }

    @Test
    void DeveRetornarValorZeroComPrecoZero() {
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();

        //Act
        double resultado = calculadoraDePedidos.calcularTotal(0.00, 5, 10.0);

        //Assert
        assertEquals(0, resultado);
    }

    @Test
    void DeveRetornarPreçoSemDescontoComDescontoZero() {
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();

        //Act
        double resultado = calculadoraDePedidos.calcularTotal(500.00, 2, 0.0);

        //Assert
        assertEquals(1000.0, resultado);

    }

    @Test
    void DeveRetornarPreçoZeroComDesconto100() {
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();

        //Act
        double resultado = calculadoraDePedidos.calcularTotal(500.00, 2, 100.0);

        //Assert
        assertEquals(0.0, resultado);
    }

    @Test
    void DeveCalcularCorretamenteComPrecoDecimal(){
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();

        //Act
        double resultado = calculadoraDePedidos.calcularTotal(500.25, 2, 10.0);

        //Assert
        assertEquals(900.45, resultado);
    }

    @Test
    void DeveCalcularCorretamenteComDescontoDecimal(){
        //Arrange
        CalculadoraDePedidos calculadoraDePedidos = new CalculadoraDePedidos();

        //Act
        double resultado = calculadoraDePedidos.calcularTotal(500.00, 2, 10.10);

        //Assert
        assertEquals(899.0, resultado);
    }

    @Test
    void DeveRetornarTrueParaFreteGratis() {
        //Arrange
        CalculadoraDePedidos calculadora = new CalculadoraDePedidos();
        //Act
        double total = calculadora.calcularTotal(500.00, 1, 0.0); // total = 500
        //Assert
        assertTrue(calculadora.isFreteGratis(total));
    }

    @Test
    void DeveRetornarFalseParaFreteCobrado() {
        //Arrange
        CalculadoraDePedidos calculadora = new CalculadoraDePedidos();
        //Act
        double total = calculadora.calcularTotal(100.00, 2, 0.0); // total = 200
        //Assert
        assertFalse(calculadora.isFreteGratis(total));
    }


}
