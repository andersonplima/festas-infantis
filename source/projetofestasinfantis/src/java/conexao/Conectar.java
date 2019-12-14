/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ander
 */
public class Conectar {

    //  static ResourceBundle res = ResourceBundle.getBundle("siscep.Res");
    private static boolean DEBUG = false;
    private Connection connection;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    // Parametros de Produção - Tauceti.
    private static Conectar rep = null;

    private Conectar() {
    }

    public static synchronized Conectar getInstance() {
        if (rep == null) {
            rep = new Conectar();
        }
        return rep;
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfestasinfantis" + "?user=root&password=Vs120499");
        } catch (SQLException sex) {
            throw new SQLException(sex.getMessage());
        }
        return connection;
    }

    public static void devolveconexao(Connection connection) throws SQLException {
        try {
            connection.close();
        } catch (Exception ex) {
            throw new SQLException(ex.getMessage());
        }

    }

}
