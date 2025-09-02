package exemplo;

public class Pessoa {
    private String nome;
    private Endereco endereco; // Composição

    public Pessoa(String nome, String rua, String cidade) {
        this.nome = nome;
        // O endereço nasce junto com a pessoa
        this.endereco = new Endereco(rua, cidade);
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco.getEnderecoCompleto());
    }
}

/* EXEMPLO DEPENDÊNCIA
class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

class Relatorio {
    // Dependência: usa Pessoa como parâmetro, mas não armazena
    public void gerar(Pessoa pessoa) {
        System.out.println("=== Relatório ===");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
    }
}
*/
