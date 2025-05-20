package br.com.fiap.conexoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoOracle {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl"; // ou sua string de conexão real
    private static final String USUARIO = "rm560442";
    private static final String SENHA = "fiap25";

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver Oracle não encontrado!", e);
        }
    }
}