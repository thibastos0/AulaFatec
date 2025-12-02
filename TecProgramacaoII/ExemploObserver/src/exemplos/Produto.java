package exemplos;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private final List<ObservadorDeProduto> observadores = new ArrayList<>();

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    public void adicionarObservador(ObservadorDeProduto obs) {
        observadores.add(obs);
    }

    public void removerObservador(ObservadorDeProduto obs) {
        observadores.remove(obs);
    }

    private void notificarObservadores() {
        for (ObservadorDeProduto obs : observadores) {
            obs.atualizar(this);
        }
    }

    public void setPreco(double novoPreco) {
        this.preco = novoPreco;
        notificarObservadores();
    }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
        notificarObservadores();
    }
}
