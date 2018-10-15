/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Grupo;
import model.Usuario;

/**
 *
 * @author gabriel
 */
public class GrupoDAO {
    private static final GrupoDAO INSTANCE = new GrupoDAO();

    public static GrupoDAO getINSTANCE() {
        return INSTANCE;
    }
    
    public void save(Grupo novoGrupo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "INSERT into grupo(nome,descricao,tipo) values ('" 
                    + novoGrupo.getNome() + "','" + novoGrupo.getDescricao()+ "','" + novoGrupo.getTipo() + "')";
            st.execute(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }
    
    public List<Grupo> getGrupos() throws ClassNotFoundException{
        List<Grupo> lstGrupos = new ArrayList<Grupo>();
      
        Connection conn = null;
        Statement stmt1 = null;
        
        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM grupo" ;
            stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(sql);
            
            while (rs.next()) {  
               lstGrupos.add(new Grupo(rs.getString("nome"), rs.getString("descricao"), rs.getString("tipo")));
            }

        }catch (SQLException ex) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            closeResources(conn, stmt1);
        }
           
        return lstGrupos;
        
    }
    
    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
    }
    
}
