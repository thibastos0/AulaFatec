package br.com.financeiro.testes;

import org.junit.jupiter.api.Test;

import br.com.financeiro.MovimentoFinanceiro;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MovimentoFinanceiroTest {

    @Test
    public void DeveRetonarValorPagamentoComSucesso() {
        
        //Arrange
        MovimentoFinanceiro movimentoFinanceiro = new MovimentoFinanceiro();
    
        //Act
        float ValorPagamento = movimentoFinanceiro.CalculaValorPagamento((float)1000.0, (float)100.55);

        //Assert
        assertEquals((float)1100.55, ValorPagamento);

    }
    @Test
    public void DeveGerarVencimentoEm10Dias() throws Exception {
  
        //Arrange
        MovimentoFinanceiro movimentoFinanceiro = new MovimentoFinanceiro();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dtEmissao = sdf.parse("15/11/2025");
    
        //Act
        //Act

        Date dataVencimento = movimentoFinanceiro.GeraVencimento(dtEmissao);

        //Assert
        Date dataEsperada = sdf.parse("25/11/2025");
        assertEquals(dataEsperada, dataVencimento);

    }

}
