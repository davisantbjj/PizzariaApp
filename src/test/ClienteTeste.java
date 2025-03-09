package test;

import dao.ClienteDAO;
import model.Cliente;
import java.util.List;

public class ClienteTeste {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        // Criar um novo cliente
        Cliente novoCliente = new Cliente(0, "João Silva", "11999998888", "Rua A, 123");
        boolean inserido = clienteDAO.inserirCliente(novoCliente);
        System.out.println("Cliente inserido: " + inserido);

        // Listar clientes
        List<Cliente> clientes = clienteDAO.consultarClientes();
        System.out.println("\nClientes cadastrados:");
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", Telefone: " + c.getTelefone() + ", Endereço: " + c.getEndereco());
        }

        // Atualizar cliente (se houver pelo menos um cliente cadastrado)
        if (!clientes.isEmpty()) {
            Cliente clienteParaAtualizar = clientes.get(0);
            clienteParaAtualizar.setNome("João Atualizado");
            boolean atualizado = clienteDAO.atualizarCliente(clienteParaAtualizar);
            System.out.println("\nCliente atualizado: " + atualizado);
        }

        // Deletar cliente (se houver pelo menos um cliente cadastrado)
        if (!clientes.isEmpty()) {
            boolean deletado = clienteDAO.deletarCliente(clientes.get(0).getId());
            System.out.println("\nCliente deletado: " + deletado);
        }
    }
}
