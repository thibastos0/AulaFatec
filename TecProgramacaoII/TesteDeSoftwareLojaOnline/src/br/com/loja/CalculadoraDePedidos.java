package br.com.loja;

public class CalculadoraDePedidos {
    
    public double calcularTotal(double precoUnitario, int quantidade, double descontoPercentual) {
        if (precoUnitario < 0 || quantidade < 0 || descontoPercentual < 0) {
            throw new IllegalArgumentException("Valores negativos não são permitidos");
        }
        double subtotal = precoUnitario * quantidade;
        double desconto = subtotal * (descontoPercentual / 100);
        
        return subtotal - desconto;

    }

    public boolean isFreteGratis(double total) {
        return total > 300.0;
    }
}