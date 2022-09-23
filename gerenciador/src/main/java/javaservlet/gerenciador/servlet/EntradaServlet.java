package javaservlet.gerenciador.servlet;

import javaservlet.gerenciador.actions.Acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

//@WebServlet(name = "EntradaServlet", value = "/entrada")
public class EntradaServlet extends HttpServlet {
    @Override protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String paramAction = req.getParameter("action");

//        HttpSession session = req.getSession();
//        boolean usuarioNaoAutenticado = session.getAttribute("usuarioLogado") == null;
//        boolean actionProtegida = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));
//
//        if (actionProtegida && usuarioNaoAutenticado) {
//            resp.sendRedirect("entrada?action=LoginForm");
//            return;
//        }

        ControllerFilter.nomeClasse(req, resp, paramAction);
    }
}
