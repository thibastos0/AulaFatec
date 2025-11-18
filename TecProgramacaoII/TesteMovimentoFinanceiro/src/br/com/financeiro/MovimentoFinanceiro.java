package br.com.financeiro;

import java.util.Calendar;
import java.util.Date;

public class MovimentoFinanceiro {

    private int ID;
    private char TipoES;
    private Date DataEmissao;
    private int Cliente;
    private Date DataVencimento;
    private Date DataPagamento;
    private float ValorOriginal;
    private float ValorJuros;
    private float ValorPagamento;

    public int GeraID(int valorIncremento) {

        return this.ID + valorIncremento;

    }

    public Date GeraVencimento(Date dtEmissao) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(dtEmissao);
        cal.add(Calendar.DATE, 10); // vencimento em 10 dias
        this.DataVencimento = cal.getTime();

        return this.DataVencimento;

    }

    public float CalculaJuros(float valorOriginal) {

        // Exemplo simples: 2% de juros fixos
        this.ValorJuros = valorOriginal * 0.02f;

        return this.ValorJuros;

    }


    public float CalculaValorPagamento(float valorOriginal, float valorJuros) {

        this.ValorPagamento = valorOriginal + valorJuros;

        return this.ValorPagamento;

    }

}