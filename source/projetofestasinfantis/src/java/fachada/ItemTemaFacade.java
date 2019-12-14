/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.ArrayList;
import bean.ItemTema;
import dao.ItemTemaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class ItemTemaFacade {
    private ItemTemaDAO dao;
    
    private ItemTemaFacade() {
        dao = new ItemTemaDAO();
    }

    private static ItemTemaFacade itemTemaFacade = null;

    public static synchronized ItemTemaFacade getInstance() {
        if (itemTemaFacade == null) {
            itemTemaFacade = new ItemTemaFacade();
        }

        return itemTemaFacade;
    }
    
    public ArrayList<ItemTema> listagemItemTema() {
        try {
            return dao.list();
        } catch (SQLException ex) {
            Logger.getLogger(ItemTemaFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
    
    public boolean inserirItemTema(String descricaoItem, int idTema) {
        ItemTema item = new ItemTema();
        item.setDescricaoItem(descricaoItem);
        item.setIdTema(idTema);
        try {
            return dao.insert(item) > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ItemTemaFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
