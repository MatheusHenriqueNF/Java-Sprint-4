package br.com.fiap.main;

import br.com.fiap.beans.Caminho;
import br.com.fiap.dto.LinhaEstacaoDTO;
import br.com.fiap.service.UsuarioService;
import br.com.fiap.service.EstacaoService;
import br.com.fiap.service.DuvidaFrequenteService;
import br.com.fiap.service.IdiomaService;
import br.com.fiap.dao.LinhaDAO;
import br.com.fiap.model.UsuarioModel;
import br.com.fiap.model.LinhaModel;
import br.com.fiap.model.EstacaoModel;
import br.com.fiap.model.DuvidaFrequenteModel;
import br.com.fiap.model.IdiomaModel;

import java.sql.SQLException;
import java.util.Scanner;

public class Teste {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🔧 Testes da API - Banco Oracle");

        UsuarioService usuarioService = new UsuarioService();
        LinhaDAO linhaDAO = new LinhaDAO();
        EstacaoService estacaoService = new EstacaoService();
        DuvidaFrequenteService duvidaService = new DuvidaFrequenteService();
        IdiomaService idiomaService = new IdiomaService(); // NOVO

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Fazer login");
            System.out.println("2 - Cadastrar novo usuário");
            System.out.println("3 - Listar usuários");
            System.out.println("4 - Listar linhas");
            System.out.println("5 - Listar estações");
            System.out.println("6 - Listar dúvidas frequentes");
            System.out.println("7 - Listar estações por linha");
            System.out.println("8 - Calcular rota");
            System.out.println("9 - Listar idiomas"); // NOVO
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Login: ");
                        String login = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        if (usuarioService.fazerLogin(login, senha)) {
                            System.out.println("✅ Login bem-sucedido!");
                        } else {
                            System.out.println("❌ Credenciais inválidas.");
                        }
                    }
                    case 2 -> {
                        System.out.print("Login: ");
                        String login = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        System.out.print("Cargo: ");
                        String cargo = scanner.nextLine();
                        if (usuarioService.cadastrarUsuario(login, senha, cargo)) {
                            System.out.println("✅ Usuário cadastrado com sucesso!");
                        } else {
                            System.out.println("❌ Falha ao cadastrar.");
                        }
                    }
                    case 3 -> {
                        for (UsuarioModel u : usuarioService.listarUsuarios()) {
                            System.out.println("ID: " + u.getIdUsuario() +
                                    " | Login: " + u.getLogin() +
                                    " | Cargo: " + u.getCargo());
                        }
                    }
                    case 4 -> {
                        for (LinhaModel l : linhaDAO.findAll()) {
                            System.out.println("ID: " + l.getIdLinha() +
                                    " | Nome: " + l.getNomeLinha() +
                                    " | Status: " + l.getStatus());
                        }
                    }
                    case 5 -> {
                        for (EstacaoModel e : estacaoService.listarEstacoes()) {
                            System.out.println("ID: " + e.getIdEstacoes() +
                                    " | Nome: " + e.getNomeEstacao() +
                                    " | Status: " + e.getStatus());
                        }
                    }
                    case 6 -> {
                        for (DuvidaFrequenteModel d : duvidaService.listarDuvidas()) {
                            System.out.println("🟨 Pergunta: " + d.getPergunta());
                            System.out.println("🟩 Resposta: " + d.getResposta());
                            System.out.println("-----------------------------");
                        }
                    }
                    case 7 -> {
                        System.out.println("📍 Estações agrupadas por linha:\n");
                        String linhaAtual = "";
                        for (LinhaEstacaoDTO dto : linhaDAO.listarEstacoesPorLinha()) {
                            if (!dto.getNomeLinha().equals(linhaAtual)) {
                                linhaAtual = dto.getNomeLinha();
                                System.out.println("🚆 Linha: " + linhaAtual);
                            }
                            System.out.println("   ↳ Estação: " + dto.getNomeEstacao());
                        }
                    }
                    case 8 -> {
                        Caminho.consultarCaminhoConsole(scanner);
                    }
                    case 9 -> {
                        for (IdiomaModel i : idiomaService.listarIdiomas()) {
                            System.out.println("ID: " + i.getIdIdioma() +
                                    " | Idioma: " + i.getIdioma() +
                                    " | Usuário: " + i.getIdUsuario());
                        }
                    }
                    case 0 -> continuar = false;
                    default -> System.out.println("❌ Opção inválida");
                }
            } catch (SQLException e) {
                System.err.println("Erro durante operação: " + e.getMessage());
            }
        }

        System.out.println("✅ Encerrando testes...");
    }
}
