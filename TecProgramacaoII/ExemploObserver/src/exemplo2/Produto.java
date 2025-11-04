package exemplo2;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private List<ObservadorDeProduto> observadores = new ArrayList<>();

    public Produto(String nome, double preco, int quantidade) {
       // this.setNome(nome);
    	this.nome=nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void adicionarObservador(ObservadorDeProduto obs) {
        observadores.add(obs);
    }

    public void removerObservador(ObservadorDeProduto obs) {
        observadores.remove(obs);
    }

    public void notificarObservadores() {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public double getQuantidade() {
		return quantidade;
	}
}