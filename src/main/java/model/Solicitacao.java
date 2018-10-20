/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabriel
 */
public class Solicitacao {
    private int id = 0;
    private String grupo, usuario, email, status = "Pendente";

    public Solicitacao(int id, String grupo, String usuario, String email, String status) {
        this.id = id;
        this.grupo = grupo;
        this.usuario = usuario;
        this.email = email;
        this.status = status;
    }

    public Solicitacao(String grupo, String usuario, String email) {
        this.grupo = grupo;
        this.usuario = usuario;
        this.email = email;
   }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
