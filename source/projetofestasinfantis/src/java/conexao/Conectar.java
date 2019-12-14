/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class Conectar {
    private static boolean DEBUG = false;
    private static Conectar rep = null;

    private Conectar() {
    }

    public static synchronized Conectar getInstance() {
        if (rep == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            }
            rep = new Conectar();
        }
        return rep;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfestasinfantis" + "?user=root&password=Vs120499");
        } catch (SQLException sex) {
            throw new SQLException(sex.getMessage());
        }
        return connection;
    }

    public void devolveconexao(Connection connection) throws SQLException {
        try {
            connection.close();
        } catch (Exception ex) {
            throw new SQLException(ex.getMessage());
        }

    }

}
