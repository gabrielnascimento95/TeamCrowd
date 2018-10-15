/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Grupo;
import persistence.GrupoDAO;

/**
 *
 * @author gabriel
 */
public class CadastroGrupoAction implements Action {

    @Override 
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String nome = (String) request.getParameter("nome");
        String descricao = (String) request.getParameter("descricao");
        String tipo = (String) request.getParameter("tipo");
        
        Grupo novoGrupo = new Grupo(nome, descricao, tipo);
        GrupoDAO save = new GrupoDAO();
        try {
           save.save(novoGrupo);
           response.setContentType("text/html;charset=UTF-8");
           request.getRequestDispatcher("busca.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroGrupoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
