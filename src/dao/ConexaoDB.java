package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:mysql://localhost:3306/Pizzaria"; // Substitua pelo seu banco de dados
    private static final String USER = "root"; // Substitua pelo seu usuário do banco
    private static final String PASSWORD = "chatbot"; // Substitua pela senha do banco, se necessário

    public static Connection getConnection() throws SQLException {
        try {
            // Carregar o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Estabelecer a conexão com o banco de dados
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do MySQL não encontrado.");
            throw new SQLException("Driver do MySQL não encontrado.", e);
        }
    }

    public static void main(String[] args) {
        // Teste de conexão
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Conexão bem-sucedida!");
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}
