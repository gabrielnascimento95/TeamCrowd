/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Solicitacao;

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
