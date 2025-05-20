package br.com.fiap.main;

import br.com.fiap.conexoes.ConexaoOracle;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("🔌 Testando conexão com o banco Oracle...");

        try (Connection conn = ConexaoOracle.conectar()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Conexão estabelecida com sucesso!");
            } else {
                System.out.println("⚠️ Conexão não estabelecida.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao conectar com o banco de dados:");
            e.printStackTrace();
        }
    }
}
