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
import model.Usuario;
import persistence.CadastroUsuarioDAO;

/**
 *
 * @author gabriel
 */
public class CadastroUsuarioAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String nome = (String) request.getParameter("nomeUsuario");
        String token = (String) request.getParameter("token");
        String nivel = (String) request.getParameter("estudo");
        String profissao = (String) request.getParameter("profissao");
        String senha = (String) request.getParameter("senhaUsuario");
        String email = (String) request.getParameter("emailUsario");
        String descricao = (String) request.getParameter("descricao");
        String dataNascimento = (String) request.getParameter("dataNasc");
        
        Usuario user = new Usuario(nome,email,senha,token,profissao,nivel,descricao, dataNascimento);
        CadastroUsuarioDAO save = new CadastroUsuarioDAO();
        try {
            save.save(user);
            response.setContentType("text/html;charset=UTF-8");
           request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
