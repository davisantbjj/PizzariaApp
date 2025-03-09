package test;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteTeste {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        
        // Testando inserção de cliente
        Cliente cliente = new Cliente(0, "João Silva", "joao@gmail.com", "123456789", "Rua 1");
        boolean inserido = clienteDAO.inserirCliente(cliente);
        System.out.println("Cliente inserido: " + inserido);
        
        // Testando consulta de clientes
        System.out.println("\nClientes cadastrados:");
        clienteDAO.consultarClientes();
        
        // Testando atualização de cliente
        cliente.setNome("João Silva Atualizado");
        boolean atualizado = clienteDAO.atualizarCliente(cliente);
        System.out.println("\nCliente atualizado: " + atualizado);
        
        // Testando exclusão de cliente
        boolean deletado = clienteDAO.deletarCliente(cliente.getId());
        System.out.println("\nCliente deletado: " + deletado);
    }
}
