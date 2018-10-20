/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author gabriel
 */
public class UsuarioDAO {
    private static final UsuarioDAO INSTANCE = new UsuarioDAO();

    public static UsuarioDAO getINSTANCE() {
        return INSTANCE;
    }
    
    public boolean authUser(String login, String senha) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        boolean valida = false;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT email,senha FROM usuario WHERE email= ? AND senha = ?");
            st.setString(1, login);
            st.setString(2, senha);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    valida = true;
                }
            }catch (Exception e){
                System.out.printf("Problema com o Statement");
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return valida;
    }
    
    public String getToken(String email) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        String token = "";

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT token FROM usuario WHERE email= ? ");
            st.setString(1, email);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    token = rs.getString("token");
                }
            }catch (Exception e){
                System.out.printf("Problema com o Statement");
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return token;
    }
    
    public int getIdUser(String email) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        int id = 0;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT id FROM usuario WHERE email= ? ");
            st.setString(1, email);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
            }catch (Exception e){
                System.out.printf("Problema com o Statement");
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return id;
    }
    
    public List<Usuario> getUsers() throws ClassNotFoundException{
        List<Usuario> lstUsuarios = new ArrayList<Usuario>();
      
        Connection conn = null;
        Statement stmt1 = null;
        
        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM usuario" ;
            stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(sql);
            
            while (rs.next()) {  
               lstUsuarios.add(new Usuario(rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("token"), rs.getString("profissional"), rs.getString("estudo"), rs.getString("descricao"), rs.getString("dt_nascimento")));
            }

        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            closeResources(conn, stmt1);
        }
           
        return lstUsuarios;
        
    }
    
    public String getEmail(String nome) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        String email = "";

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT email FROM usuario WHERE nome= ? ");
            st.setString(1, nome);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    email = rs.getString("email");
                }
            }catch (Exception e){
                System.out.printf("Problema com o Statement");
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return email;
    }
    
    public String getNome(String email) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        String nome = "";

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT nome FROM usuario WHERE email= ? ");
            st.setString(1, email);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    nome = rs.getString("nome");
                }
            }catch (Exception e){
                System.out.printf("Problema com o Statement");
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return nome;
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
