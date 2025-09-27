package conexaoBD;


public class Conexao {

    public static void main(String[] args) {
        
        ExemploJDBC conexao1 = ExemploJDBC.getInstance();
        ExemploJDBC conexao2 = ExemploJDBC.getInstance();

        if (conexao1 == conexao2) {
            System.out.println("As conexões são a mesma instância.");
        } else {
            System.out.println("As conexões são instâncias diferentes.");
        }

        conexao1.queryConsulta("SELECT nome, email, DATE_FORMAT(data_nascimento, '%d/%m/%Y') as data_nascimento FROM teste");
        conexao2.queryAtualiza("UPDATE teste SET email = 'jorge.silva@example.com' WHERE nome = 'Jorge Silva'");

        conexao1.fecharConexao();
        System.out.println("Após fechar a conexão com o banco de dados.");
        // Tentando usar a conexão novamente
        //conexao2.queryConsulta("SELECT * from teste");
    }

}
