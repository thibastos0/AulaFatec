package exemplo2;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Notebook Gamer", 5999.90, 10);
        Produto produto2 = new Produto("Monito LCD", 2563, 10);
        Produto produto3 = new Produto("Mouse", 376, 10);
        Produto produto4 = new Produto("Teclado digital", 1999.90, 10);
     // Observador 1: exibe no console
       // produto1.adicionarObservador(p -> System.out.println("Observador Console: " + p.getNome() + " -> R$" + p.getPreco()+" - " + p.getQuantidade()));

        // Observador 2: faz outra ação (ex: atualizar uma tela genérica)
       // produto1.adicionarObservador(p -> System.out.println("Outro Observador: quantidade = " + p.getQuantidade()));

        // Mudanças
        produto1.setPreco(4000.0);
        produto1.setQuantidade(8);

        produto1.setPreco(5000.0);

        // Cria uma tela que observa o produto
        TelaDeExibicaoDeProduto tela = new TelaDeExibicaoDeProduto(produto1);
        TelaDeExibicaoDeProduto tela2 = new TelaDeExibicaoDeProduto(produto2);
        TelaDeExibicaoDeProduto tela3 = new TelaDeExibicaoDeProduto(produto3);
        TelaDeExibicaoDeProduto tela4 = new TelaDeExibicaoDeProduto(produto4);


        // Simula mudanças no produto
       // produto.setPreco(5499.90);
        produto1.setQuantidade(8);
        produto1.setQuantidade(7);
        produto1.setQuantidade(6);
        produto2.setQuantidade(6);
        produto3.setQuantidade(7);
        produto4.setQuantidade(9);
        //produto.removerObservador(tela);
        //produto.setQuantidade(5);
    }
}
