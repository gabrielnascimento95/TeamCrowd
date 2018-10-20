/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Util.MailJava;
import Util.MailJavaSender;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;

/**
 *
 * @author gabriel
 */
public class DisparaEmailAction {

    public DisparaEmailAction() {
    }
    
    
    public void disparaEmail(String nomeUsuario, String emailUsuario, String grupo, String emailAnfitriao){
        try{
            new MailJavaSender().senderMail(new MailJava(nomeUsuario,emailUsuario, grupo,emailAnfitriao));
            System.out.print("Enviado com sucesso.");
        }catch (UnsupportedEncodingException | MessagingException e) {
            System.out.print(e.getMessage());
        }   
    }
    /*
        
        */
}
