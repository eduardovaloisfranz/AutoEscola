package autoEscola.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    private static final String url = "jdbc:mysql://localhost/autoescola";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConnection() {

        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;   

    }
}
