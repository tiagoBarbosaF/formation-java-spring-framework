package javaservlet.gerenciador.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginForm implements Acao {
    @Override public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        return "forward:formLogin.jsp";
    }
}
