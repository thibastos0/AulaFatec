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

        if (valorIncremento < 0) {
            throw new IllegalArgumentException("Valor de Incremento não pode ser negativo!");
        }
        return this.ID + valorIncremento;

    }

    public Date GeraVencimento(Date dtEmissao) {

        if (dtEmissao == null){
            throw new NullPointerException("Data inválida!");
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(dtEmissao);
        cal.add(Calendar.DATE, 10); // vencimento em 10 dias
        while (!isDiaUtil(cal.getTime())){
            cal.add(Calendar.DATE, 1);
        }
        this.DataVencimento = cal.getTime();

        return this.DataVencimento;

    }

    public boolean isDiaUtil(Date data){
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);

        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
        return diaSemana != Calendar.SATURDAY && diaSemana != Calendar.SUNDAY;
    }

    public float CalculaJuros(float valorOriginal) {

        if (valorOriginal < 0){
            throw new IllegalArgumentException("O valor não pode ser negativo!");
        }

        // Exemplo simples: 2% de juros fixos
        this.ValorJuros = valorOriginal * 0.02f;

        return this.ValorJuros;

    }


    public float CalculaValorPagamento(float valorOriginal, float valorJuros) {

        if (valorOriginal < 0 || valorJuros < 0) {
            throw new IllegalArgumentException("Os valores não podem ser negativos!");
        }

        this.ValorPagamento = valorOriginal + valorJuros;

        return this.ValorPagamento;

    }

}