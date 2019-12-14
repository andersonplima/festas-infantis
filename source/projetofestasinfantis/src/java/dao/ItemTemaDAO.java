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
            String sql = "SELECT idItem, descricaoItem FROM itemtema ORDER BY descricao";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ItemTema t = new ItemTema();
                
                t.setIdItem(rs.getInt("idItem"));
                t.setDescricaoItem(rs.getString("descricaoItem"));
                
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
}
