/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ItemTema;
import conexao.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ander
 */
public class ItemTemaDAO {

    private Conectar co = Conectar.getInstance();

    public ItemTemaDAO() {
    }

    public ArrayList list() throws SQLException {
        ArrayList list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = co.getConnection();
            String sql = "SELECT idItem, descricaoItem, idTema FROM itemtema ORDER BY descricaoItem";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ItemTema t = new ItemTema();

                t.setIdItem(rs.getInt("idItem"));
                t.setDescricaoItem(rs.getString("descricaoItem"));
                t.setIdTema(rs.getInt("idTema"));

                list.add(t);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            rs.close();
            pstmt.close();
            conn.rollback();
            e.printStackTrace();
        } finally {
            co.devolveconexao(conn);
        }

        return list;
    }

    public int insert(ItemTema itemtema) throws SQLException {
        String sql = "INSERT INTO itemtema (descricaoItem, idTema) VALUES (?, ?)";
        int a = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = co.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, itemtema.getDescricaoItem());
            pstmt.setInt(2, itemtema.getIdTema());
            a = pstmt.executeUpdate();
            pstmt.close();
            return a;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        } finally {
            co.devolveconexao(conn);
        }
    }
}
