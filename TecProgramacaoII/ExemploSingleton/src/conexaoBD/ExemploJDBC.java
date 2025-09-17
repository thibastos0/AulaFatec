package conexaoBD;

import java.sql.*;



public class ExemploJDBC {

    private static ExemploJDBC instance;
    private Connection con;
    private Statement stmt;
    
    private ExemploJDBC() {
        // Construtor privado para evitar instância externa
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "teste", "teste");
            this.stmt = con.createStatement();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ExemploJDBC getInstance() {

        if (instance == null) {
            instance = new ExemploJDBC();

        }
        return instance;
    }

    public void queryConsulta(String sql) {
        // Método para executar consultas SQL
        // Implementação omitida para brevidade
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome") + ", E-mail: " + rs.getString("email") + ", Data de Nascimento: " + rs.getString("data_nascimento"));
                
                //System.out.println("Data de Nascimento sem formatação: " + rs.getDate("data_nascimento"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void queryAtualiza(String sql) {
        // Método para executar comandos SQL (INSERT, UPDATE, DELETE)
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fecharConexao() {
        // Método para fechar a conexão com o banco de dados
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
            instance = null; // Permitir nova instância após fechar a conexão
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}