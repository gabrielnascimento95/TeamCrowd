package br.ufjf.teamcrowd;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.kohsuke.github.GitHub;

/**
 *
 * @author Rian Alves
 */
public class Conexao {
    
    GitHub gitHub;
    
    private String token = "";

    public GitHub getConexao() throws IOException {
        if (gitHub == null) {
            gitHub = GitHub.connectUsingOAuth(token);
        }
        return gitHub;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
