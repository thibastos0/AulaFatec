package exemplo2;


public class TelaDeExibicaoDeProduto implements ObservadorDeProduto {
    private Produto produto;

    public TelaDeExibicaoDeProduto(Produto produto) {
        this.produto = produto;
        produto.adicionarObservador(this);
    }

    @Override
    public void atualizar(Produto produto) {
        System.out.println("Atualizando tela de exibição do produto: " + produto.getNome() + " - Preço: " + produto.getPreco() + " - Quantidade em estoque: " + produto.getQuantidade());
    }
}