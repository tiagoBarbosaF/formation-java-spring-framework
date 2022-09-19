package javaservlet.gerenciador.servlet;

import javaservlet.gerenciador.actions.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "EntradaServlet", value = "/entrada")
public class EntradaServlet extends HttpServlet {
    @Override protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String paramAction = req.getParameter("action");

        String nomeClasse = "javaservlet.gerenciador.actions." + paramAction;

        String nome;

        try {
            Class<?> classe = Class.forName(nomeClasse);
            Acao acao = (Acao) classe.getDeclaredConstructor().newInstance();
            nome = acao.execute(req, resp);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new ServletException(e);
        }

        assert nome != null;
        String[] tipoEAcao = nome.split(":");
        if (tipoEAcao[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/" + tipoEAcao[1]);
            rd.forward(req, resp);
        } else {
            resp.sendRedirect(tipoEAcao[1]);
        }
    }
}
