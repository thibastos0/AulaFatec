package br.com.financeiro.testes;

import org.junit.jupiter.api.Test;

import br.com.financeiro.MovimentoFinanceiro;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MovimentoFinanceiroTest {

    private final MovimentoFinanceiro movimentoFinanceiro = new MovimentoFinanceiro();

    @Test
    public void deveRetonarValorPagamentoComSucesso() {
        
        //Arrange
        //MovimentoFinanceiro movimentoFinanceiro = new MovimentoFinanceiro();
    
        //Act
        float ValorPagamento = movimentoFinanceiro.CalculaValorPagamento(1000.0f, 100.55f);

        //Assert
        assertEquals(1100.55f, ValorPagamento);

    }

    @Test
    public void deveRetornarCalculoJurosCorretamente(){

        //Arrange
        //MovimentoFinanceiro movimentoFinanceiro = new MovimentoFinanceiro();

        //Act
        float valorJuros = movimentoFinanceiro.CalculaJuros(1000.0f);

        //Assert
        assertEquals(20.0f, valorJuros);


    }

    @Test
    public void deveRetornarExcecaoParaValoresNegativosEmPagamento(){
        //Arrange
        //MovimentoFinanceiro movimentoFinanceiro = new MovimentoFinanceiro();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> { movimentoFinanceiro.CalculaValorPagamento(-1000.0f, 10.0f);}, "Os valores não devem ser negativos!"
        );

    }

    @Test
    public void deveRetornarExcecaoParaJurosComValoresNegativos(){

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            movimentoFinanceiro.CalculaJuros(-1000.0f);}
        );
    }

    @Test
    public void deveGerarVencimentoEm10Dias() throws Exception {
        // Arrange
        //MovimentoFinanceiro movimentoFinanceiro = new MovimentoFinanceiro();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dtEmissao = sdf.parse("18/11/2025");

        // Act
        Date dataVencimento = movimentoFinanceiro.GeraVencimento(dtEmissao);

        // Assert
        Date dataEsperada = sdf.parse("28/11/2025");
        assertEquals(dataEsperada, dataVencimento, "O vencimento deve ser 10 dias após a emissão"); //verificando dias úteis somente

    }

    @Test
    public void deveRetornarExcecaoParaDataNull(){
        //Arrange
        Date dtEmissao = null;

        //Act & Assert
        assertThrows(NullPointerException.class, () -> {
            movimentoFinanceiro.GeraVencimento(dtEmissao);}
        );
    }

    @Test
    public void deveCalcularJurosZeroParaValorZero() {
        // Arrange
        //MovimentoFinanceiro movimentoFinanceiro = new MovimentoFinanceiro();

        // Act
        float valorJuros = movimentoFinanceiro.CalculaJuros(0.0f);

        // Assert
        assertEquals(0.0f, valorJuros, "Juros sobre valor zero deve ser zero");
    }

    @Test
    public void deveIncrementarIDCorretamente() {
        // Arrange
        //MovimentoFinanceiro movimentoFinanceiro = new MovimentoFinanceiro();

        // Act
        int novoID = movimentoFinanceiro.GeraID(5);

        // Assert
        assertEquals(5, novoID, "O ID deve ser incrementado corretamente");
    }

    @Test
    public void deveRetornarExcecaoParaIncrementosNegativos(){
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {movimentoFinanceiro.GeraID(-10);}
        );
    }

}
