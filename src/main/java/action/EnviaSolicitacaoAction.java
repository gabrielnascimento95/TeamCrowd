/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.UsuarioDAO;

/**
 *
 * @author gabriel
 */
public class EnviaSolicitacaoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        List<Usuario> lstUsuarios = new ArrayList<>();
        lstUsuarios = UsuarioDAO.getINSTANCE().getUsers();
        request.setAttribute("listaUsuarios", lstUsuarios);
        
        RequestDispatcher despachante = request.getRequestDispatcher("/enviaSolicitacao.jsp");
        despachante.forward(request, response);
    }
    
}
