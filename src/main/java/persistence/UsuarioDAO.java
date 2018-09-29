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
import javax.servlet.http.HttpSession;

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
            st = conn.prepareStatement("SELECT nome,senha FROM usuario WHERE nome= ? AND senha = ?");
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
