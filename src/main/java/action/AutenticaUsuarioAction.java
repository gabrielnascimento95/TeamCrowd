/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import br.ufjf.teamcrowd.Conexao;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistence.UsuarioDAO;

/**
 *
 * @author gabriel
 */
public class AutenticaUsuarioAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        Conexao conection = new Conexao();
        String email = (String) request.getParameter("usuario");
        String senha = (String)request.getParameter("senha");
        boolean auth = false;
        //int idUser = 0;
        String nomeUsuarioLogado = "";

      try {        
            auth = UsuarioDAO.getINSTANCE().authUser(email, senha);
            //idUser = UsuarioDAO.getINSTANCE().getIdUser(email);
            nomeUsuarioLogado = UsuarioDAO.getINSTANCE().getNome(email);
        } catch (SQLException ex) {
            Logger.getLogger(AutenticaUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(auth){
           HttpSession session = request.getSession(true);
           session.setAttribute("logado", new String("true"));
           //session.setAttribute("idUser", idUser);
           session.setAttribute("nomeUsuarioLogado", nomeUsuarioLogado);
           session.setAttribute("emailUsuarioLogado", email);
           response.setContentType("text/html;charset=UTF-8");
           request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if(request.getSession().getAttribute("logado").equals(new String("true"))){
           response.setContentType("text/html;charset=UTF-8");
           request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            response.setContentType("text/html;charset=UTF-8");
           request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }
    
}
