/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.SolicitacoesDAO;

/**
 *
 * @author gabriel
 */
public class SolicitacaoAceitaAction implements Action{

    String parametro = "";
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        //String email = (String) request.getAttribute("email");
        //String nome = (String) request.getAttribute("nome");
        //String grupo = (String) request.getAttribute("grupo"); 
        
        try {
            SolicitacoesDAO.getINSTANCE().atualizaStatus("Gabriel", "gabrieljf13@gmail.com", "MasterTeam");
            System.out.print("Feito");
            response.setContentType("text/html;charset=UTF-8");
           request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoAceitaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
