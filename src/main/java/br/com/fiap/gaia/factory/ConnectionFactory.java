package br.com.fiap.gaia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");

        String url = System.getenv().getOrDefault(
                "GAIA_DB_URL",
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl"
        );

        String user = System.getenv("GAIA_DB_USER");
        String password = System.getenv("GAIA_DB_PASSWORD");

        if (user == null || password == null) {
            throw new IllegalStateException(
                    "Defina as variáveis de ambiente GAIA_DB_USER e GAIA_DB_PASSWORD."
            );
        }

        return DriverManager.getConnection(url, user, password);
    }
}
