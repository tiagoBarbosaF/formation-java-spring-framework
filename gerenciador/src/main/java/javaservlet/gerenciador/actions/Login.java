package javaservlet.gerenciador.actions;

import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login implements Acao {
    @Override public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        System.out.printf("%nLogando: %s%n", login);

        Banco banco = new Banco();
        Usuario usuario = banco.existeUsuario(login, senha);

        if (usuario != null) {
            System.out.println("Usuário existe no sistema.");
            return "redirect:entrada?action=ListaEmpresas";
        } else {
            return "redirect:entrada?action=LoginForm";
        }
    }
}
