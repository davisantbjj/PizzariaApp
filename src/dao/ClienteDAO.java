package dao;

import java.sql.*;
import model.Cliente;

public class ClienteDAO {

    // Método para inserir um novo cliente no banco
    public boolean inserirCliente(Cliente cliente) {
        String query = "INSERT INTO cliente (nome, email, telefone, endereco) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexaoDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEndereco());
            
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para consultar todos os clientes
    public void consultarClientes() {
        String query = "SELECT * FROM cliente";
        try (Connection con = ConexaoDB.getConnection(); 
             Statement stmt = con.createStatement(); 
             ResultSet rs = stmt.executeQuery(query)) {
             
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");
                System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email + 
                                   ", Telefone: " + telefone + ", Endereço: " + endereco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um cliente no banco de dados
    public boolean atualizarCliente(Cliente cliente) {
        String query = "UPDATE cliente SET nome = ?, email = ?, telefone = ?, endereco = ? WHERE id = ?";
        try (Connection con = ConexaoDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEndereco());
            pst.setInt(5, cliente.getId());
            
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para deletar um cliente do banco de dados
    public boolean deletarCliente(int id) {
        String query = "DELETE FROM cliente WHERE id = ?";
        try (Connection con = ConexaoDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
