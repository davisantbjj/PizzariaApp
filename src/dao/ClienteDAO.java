package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;

public class ClienteDAO {
   
   public boolean inserirCliente(Cliente cliente) {
      String sql = "INSERT INTO cliente (nome, telefone, endereco) VALUES (?, ?, ?)";

      try (Connection conn = ConexaoDB.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)) {
         
         stmt.setString(1, cliente.getNome());
         stmt.setString(2, cliente.getTelefone());
         stmt.setString(3, cliente.getEndereco());
         int linhasAfetadas = stmt.executeUpdate();

         return linhasAfetadas > 0;
      } catch (SQLException e) {
         System.out.println("Erro ao inserir cliente: " + e.getMessage());
         return false;
      }
   }

   public void consultarClientes() {
      String sql = "SELECT * FROM cliente";

      try (Connection conn = ConexaoDB.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery()) {
         
         while (rs.next()) {
            int id = rs.getInt("id_cliente"); // Correção aqui
            String nome = rs.getString("nome");
            String telefone = rs.getString("telefone");
            String endereco = rs.getString("endereco");

            System.out.println("ID: " + id + ", Nome: " + nome + ", Telefone: " + telefone + ", Endereço: " + endereco);
         }
      } catch (SQLException e) {
         System.out.println("Erro ao consultar clientes: " + e.getMessage());
      }
   }

   public boolean atualizarCliente(Cliente cliente) {
      String sql = "UPDATE cliente SET nome = ?, telefone = ?, endereco = ? WHERE id_cliente = ?";

      try (Connection conn = ConexaoDB.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

         stmt.setString(1, cliente.getNome());
         stmt.setString(2, cliente.getTelefone());
         stmt.setString(3, cliente.getEndereco());
         stmt.setInt(4, cliente.getId());

         return stmt.executeUpdate() > 0;
      } catch (SQLException e) {
         System.out.println("Erro ao atualizar cliente: " + e.getMessage());
         return false;
      }
   }

   public boolean deletarCliente(int id) {
      String sql = "DELETE FROM cliente WHERE id_cliente = ?";

      try (Connection conn = ConexaoDB.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

         stmt.setInt(1, id);
         return stmt.executeUpdate() > 0;
      } catch (SQLException e) {
         System.out.println("Erro ao deletar cliente: " + e.getMessage());
         return false;
      }
   }
}
