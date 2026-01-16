package service;

import model.Ponto;
import model.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class PontoService {

    public static ArrayList<Ponto> pontoList = new ArrayList<>();

    public static void registrarEntrada() {
        Scanner sc = new Scanner(System.in);
        if (UsuarioService.usuariosList.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado no momento.");
        } else {
            try {
                System.out.print("Informe o ID do usuário para registrar a entrada: ");
                UUID idUsuario = UUID.fromString(sc.nextLine());
                System.out.print("Informe a senha do usuário: ");
                String senhaUsuario = sc.nextLine();

                Usuario usuarioEncontrado = null;
                for (Usuario u : UsuarioService.usuariosList) {
                    if (u.getIdUsuario().equals(idUsuario) && u.getSenha().equalsIgnoreCase(senhaUsuario)) {
                        usuarioEncontrado = u;
                        break;
                    }
                }

                if (usuarioEncontrado == null) {
                    System.out.println("Error. Usuário não encontrado ou senha incorreta.");
                } else {
                    Ponto pontoEntrada = null;
                    for (Ponto p : pontoList) {
                        if (p.getUsuario().getIdUsuario().equals(idUsuario) && p.getSaida() == null) {
                            pontoEntrada = p;
                            break;
                        }
                    }

                    if (pontoEntrada != null) {
                        System.out.println("A entrada já foi registrada para este usuário.");
                    } else {
                        LocalDateTime baterEntrada = LocalDateTime.now();
                        Ponto p = new Ponto(usuarioEncontrado, baterEntrada, null);
                        pontoList.add(p);
                        String entradaFormatada = baterEntrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                        System.out.println("\nEntrada registrada com sucesso!");
                        System.out.println("\nDados do usuário: " + "\nID: " + usuarioEncontrado.getIdUsuario()
                                + "\nNome: " + usuarioEncontrado.getNomeUsuario());
                        System.out.println("Horário de entrada registrada em: " + entradaFormatada);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O ID informado é inválido.");
            }
        }
    }

    public static void registrarSaida() {
        Scanner sc = new Scanner(System.in);
        if (UsuarioService.usuariosList.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado no momento.");
        } else {
            try {
                System.out.print("Informe o ID do usuário para registrar a saída: ");
                UUID idUsuario = UUID.fromString(sc.nextLine());
                System.out.print("Informe a senha do usuário: ");
                String senhaUsuario = sc.nextLine();

                Usuario usuarioEncontrado = null;
                for (Usuario u : UsuarioService.usuariosList) {
                    if (u.getIdUsuario().equals(idUsuario) && u.getSenha().equalsIgnoreCase(senhaUsuario)) {
                        usuarioEncontrado = u;
                        break;
                    }
                }

                if (usuarioEncontrado == null) {
                    System.out.println("Error. Usuário não encontrado ou senha incorreta.");
                } else {
                    Ponto ponto = null;
                    for (Ponto p : pontoList) {
                        if (p.getUsuario().getIdUsuario().equals(idUsuario) && p.getSaida() == null) {
                            ponto = p;
                            break;
                        }
                    }

                    if (ponto == null) {
                        System.out.println("Este usuário precisa registrar a Entrada antes de registrar a Saída.");
                    } else {
                        LocalDateTime baterSaida = LocalDateTime.now();
                        ponto.setSaida(baterSaida);
                        String saidaFormatada = baterSaida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                        System.out.println("\nSaída registrada com sucesso!");
                        System.out.println("\nDados do usuário: " + "\nID: " + usuarioEncontrado.getIdUsuario()
                                + "\nNome: " + usuarioEncontrado.getNomeUsuario());
                        System.out.println("Horário de saída registrada em: " + saidaFormatada);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O ID informado é inválido.");
            }
        }
    }

    public static void listarPontos() {
        if (PontoService.pontoList.isEmpty()) {
            System.out.println("Nenhum ponto registrado até o momento.");
        } else {
            System.out.println("\nLista de frequência de ponto: ");
            for (Ponto p : pontoList) {
                System.out.println(p.toString());
            }
        }
    }

    public static void comprovantePonto() {
        Scanner sc = new Scanner(System.in);
        if (UsuarioService.usuariosList.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado no momento.");
            System.out.println("Não foi possível gerar o comprovante de ponto.");
        } else {
            try {
                System.out.print("Informe o ID do usuário para gerar o comprovante: ");
                UUID idUsuarioComprovante = UUID.fromString(sc.nextLine());

                Usuario usuario = null;
                for (Usuario u : UsuarioService.usuariosList) {
                    if (u.getIdUsuario().equals(idUsuarioComprovante)) {
                        usuario = u;
                        break;
                    }
                }

                if (usuario == null) {
                    System.out.println("Usuário não encontrado ou senha incorreta.");
                } else {
                    for (Ponto p : pontoList) {
                        if (p.getEntrada() == null || p.getSaida() == null) {
                            System.out.println("Ponto incompleto (não foi possível gerar o comprovante de ponto).");
                        } else {
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                            String entradaFormatada = p.getEntrada().format(dateTimeFormatter);
                            String saidaFormatada = p.getSaida().format(dateTimeFormatter);

                            System.out.println();
                            System.out.println("==========================");
                            System.out.println("***Comprovante de Ponto***");
                            System.out.println("==========================");
                            System.out.println("Usuário: " + usuario.getNomeUsuario());
                            System.out.println("ID: " + usuario.getIdUsuario());
                            System.out.println("Entrada registrada: " + entradaFormatada);
                            System.out.println("Saída registrada: " +  saidaFormatada);
                            System.out.println("-------------------------");
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O ID informado é inválido.");
            }
        }
    }
}
