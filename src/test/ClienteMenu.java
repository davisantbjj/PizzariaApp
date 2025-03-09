package test;

import dao.ClienteDAO;
import model.Cliente;
import java.util.Scanner;

public class ClienteMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        int opcao;

        do {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1. Inserir Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    Cliente novoCliente = new Cliente(0, nome, telefone, endereco);
                    boolean inserido = clienteDAO.inserirCliente(novoCliente);
                    System.out.println("Cliente inserido: " + inserido);
                    break;
                
                case 2:
                    clienteDAO.consultarClientes();
                    break;
                
                case 3:
                    System.out.print("ID do cliente para atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    System.out.print("Novo endereço: ");
                    String novoEndereco = scanner.nextLine();
                    Cliente clienteAtualizado = new Cliente(idAtualizar, novoNome, novoTelefone, novoEndereco);
                    boolean atualizado = clienteDAO.atualizarCliente(clienteAtualizado);
                    System.out.println("Cliente atualizado: " + atualizado);
                    break;
                
                case 4:
                    System.out.print("ID do cliente para deletar: ");
                    int idDeletar = scanner.nextInt();
                    boolean deletado = clienteDAO.deletarCliente(idDeletar);
                    System.out.println("Cliente deletado: " + deletado);
                    break;
            }
        } while (opcao != 0);

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}
