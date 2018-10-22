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
import javax.servlet.http.HttpSession;
import model.Solicitacao;
import persistence.SolicitacoesDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author gabriel
 */
public class EnviaSolicitacaoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        HttpSession session = request.getSession();
        String grupo = (String) request.getParameter("grupos");
        String nomeUsuarioInt = (String) request.getParameter("usersInt");
        String nomeUsuarioExt = (String) request.getParameter("nomeUserEx");
        String emailUsuarioExt = (String) request.getParameter("emailUserEx");
        String emailUsuarioInt = " ";
        //String nomeUsuarioLogado = session.getAttribute("nomeUsuarioLogado").toString();
        String nomeUsuarioLogado = "Gabriel Nascimento";
        DisparaEmailAction correio = new DisparaEmailAction();
        
        
        if(!nomeUsuarioInt.isEmpty()){
            try{
                emailUsuarioInt = UsuarioDAO.getINSTANCE().getEmail(nomeUsuarioInt);
                SolicitacoesDAO.getINSTANCE().save(new Solicitacao(grupo,nomeUsuarioInt,emailUsuarioInt));
                System.out.print(emailUsuarioInt);
                correio.disparaEmail(nomeUsuarioInt, emailUsuarioInt, grupo, nomeUsuarioLogado);
            }catch (SQLException ex) {
                Logger.getLogger(EnviaSolicitacaoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                SolicitacoesDAO.getINSTANCE().save(new Solicitacao(grupo,nomeUsuarioExt,emailUsuarioExt));
                correio.disparaEmail(nomeUsuarioExt, emailUsuarioExt, grupo, nomeUsuarioLogado);
            } catch (SQLException ex) {
                Logger.getLogger(EnviaSolicitacaoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
}
