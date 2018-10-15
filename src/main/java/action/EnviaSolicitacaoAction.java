/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Util.MailJava;
import Util.MailJavaSender;
import controller.Action;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.UsuarioDAO;

/**
 *
 * @author gabriel
 */
public class EnviaSolicitacaoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String grupo = (String) request.getParameter("grupos");
        String nomeUsuarioInt = (String) request.getParameter("usersInt");
        String nomeUsuarioExt = (String) request.getParameter("nomeUserEx");
        String emailUsuarioExt = (String) request.getParameter("emailUserEx");
        String email = "00";
        
        try {
            email = UsuarioDAO.getINSTANCE().getEmail(nomeUsuarioInt);
            System.out.print(email);
        } catch (SQLException ex) {
            Logger.getLogger(EnviaSolicitacaoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(nomeUsuarioInt.isEmpty() && !nomeUsuarioExt.isEmpty() && !emailUsuarioExt.isEmpty()){
            try{
                new MailJavaSender().senderMail(new MailJava(nomeUsuarioExt,emailUsuarioExt, grupo,emailUsuarioExt));
                System.out.print("Feito");
            }catch (UnsupportedEncodingException | MessagingException e) {
                System.out.print(e.getMessage());
            }   
        }else if(!nomeUsuarioInt.isEmpty() && nomeUsuarioExt.isEmpty() && emailUsuarioExt.isEmpty()){
            try{
                new MailJavaSender().senderMail(new MailJava(nomeUsuarioInt,email, grupo,email));
                System.out.print("Feito");
            }catch (UnsupportedEncodingException | MessagingException e) {
                System.out.print(e.getMessage());
            }
        }else{
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("FrontController?action=PreEnvioSolicitacao").forward(request, response);
        }
         
            
    }
    
}
