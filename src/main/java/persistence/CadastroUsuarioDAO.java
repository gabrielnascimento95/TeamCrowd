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
import model.Usuario;

/**
 *
 * @author gabriel
 */
public class CadastroUsuarioDAO {
    private static final CadastroUsuarioDAO INSTANCE = new CadastroUsuarioDAO();

    public static CadastroUsuarioDAO getINSTANCE() {
        return INSTANCE;
    }
    
    public void save(Usuario novoUsuario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "INSERT into colaborador(idcolaborador,nome,email,numContribuicoes,numSeguidores,numSeguidos,localizacao,urlImagem,url) values (" 
                    + colaborador.getIdColaborador() + ",'" + colaborador.getNome() + "','" + colaborador.getEmail() + "'," + colaborador.getContribuicao() + "," + colaborador.getNumseguidos() + "," + colaborador.getNumseguidores()+ ",'"  + colaborador.getLocalizacao() + "','"  + colaborador.getUrl() + "','"  + colaborador.getImagem_URL() + "')";
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
