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
import model.Solicitacao;
import model.Usuario;

/**
 *
 * @author gabriel
 */
public class SolicitacoesDAO {
    private static final SolicitacoesDAO INSTANCE = new SolicitacoesDAO();

    public static SolicitacoesDAO getINSTANCE() {
        return INSTANCE;
    }

    public void save(Solicitacao novaSolicitacao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "INSERT into solicitacoes(grupo,usuario,email, status) values ('" 
                    + novaSolicitacao.getGrupo() + "','" + novaSolicitacao.getUsuario() + "','" + novaSolicitacao.getEmail() + "','"  + novaSolicitacao.getStatus() + "')";
            st.execute(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    
    }
    
    public void atualizaStatus(String nome, String email, String grupo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE solicitacoes set status = 'ativo' where email = '"+ email  +"' and usuario ='" + nome +"' and grupo = '"+ grupo +"'";
            st.execute(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    
    }
    
    public void NaoAtualizaStatus(String nome, String email, String grupo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE solicitacoes set status = 'recusado' where email = '"+ email  +"' and usuario ='" + nome +"' and grupo = '"+ grupo +"'";
            st.execute(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    
    }
    
    public List<Solicitacao> getRelacaoGrupos() throws ClassNotFoundException{
        List<Solicitacao> lstSolicitacao = new ArrayList<Solicitacao>();
      
        Connection conn = null;
        Statement stmt1 = null;
        
        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM usuario" ;
            stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(sql);
            
            while (rs.next()) {  
               //lstSolicitacao.add();
            }

        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            closeResources(conn, stmt1);
        }
           
        return lstSolicitacao;
        
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
