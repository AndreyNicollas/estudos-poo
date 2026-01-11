package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class ClienteService {

    public ArrayList<Cliente> clienteList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ClienteService() {
    }

    public void cadastrarCliente() {
        UUID id = UUID.randomUUID();
        System.out.print("Informe o nome do Cliente: ");
        String nome = sc.nextLine();
        System.out.print("Informe o email do Cliente: ");
        String email = sc.nextLine();
        System.out.println("Cliente cadastrado.");

        Cliente cliente = new Cliente(id, nome, email);
        clienteList.add(cliente);
    }

    public void listarClientes() {
        if (clienteList.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        } else {
            System.out.println("\n=====LISTA DE CLIENTES=====");
            for (Cliente c : clienteList) {
                System.out.println(c);
            }
        }
    }

    public void atualizarCliente() {
        if (clienteList.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        } else {
            try {
                System.out.print("Informe o id do Cliente que deseja atualizar: ");
                UUID idClienteBuscar = UUID.fromString(sc.nextLine());

                Cliente clienteEncontrado = null;

                for (Cliente c : clienteList) {
                    if (c.getIdCliente().equals(idClienteBuscar)) {
                        clienteEncontrado = c;
                        break;
                    }
                }

                if (clienteEncontrado != null) {
                    System.out.print("Informe o novo nome do Cliente: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Informe o novo email do Cliente: ");
                    String novoEmail = sc.nextLine();

                    clienteEncontrado.setNomeCliente(novoNome);
                    clienteEncontrado.setEmailCliente(novoEmail);
                    System.out.println("Dados atualizados com sucesso!");
                } else {
                    System.out.println("Cliente não encontrado.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O id informado é inválido.");
            }
        }
    }

    public void removerCliente() {
        if (clienteList.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado no momento.");
        } else {
            try {
                System.out.print("Informe o id do Cliente para remover: ");
                UUID idRemover = UUID.fromString(sc.nextLine());
                for (Cliente c : clienteList) {
                    if (c.getIdCliente().equals(idRemover)) {
                        clienteList.remove(c);
                        System.out.println("Cliente foi removido.");
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O id informado é inválido.");
            }
        }
    }

    public void buscarClientePorNome() {
        if (clienteList.isEmpty()) {
            System.out.println("Nenhum cliente foi cadastrado no momento.");
        } else {
            try {
                System.out.print("Informe o nome do Cliente para buscar: ");
                String nomeClienteBuscar = sc.nextLine();

                for (Cliente c : clienteList) {
                    if (c.getNomeCliente().toLowerCase().contains(nomeClienteBuscar.toLowerCase())) {
                        System.out.println("Cliente foi encontrado.");
                        System.out.println("Dados do Cliente: " + c);
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O id informado inválido.");
            }
        }
    }
}
