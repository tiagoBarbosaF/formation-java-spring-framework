package javaservlet.gerenciador.servlet;

import javaservlet.gerenciador.actions.Acao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ControllerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("ControllerFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAction = request.getParameter("action");
        nomeClasse(request, response, paramAction);
    }

    static void nomeClasse(HttpServletRequest request, HttpServletResponse response, String paramAction)
            throws ServletException, IOException {
        String nomeClasse = "javaservlet.gerenciador.actions." + paramAction;

        String nome;

        try {
            Class<?> classe = Class.forName(nomeClasse);
            Acao acao = (Acao) classe.getDeclaredConstructor().newInstance();
            nome = acao.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new ServletException(e);
        }

        assert nome != null;
        String[] tipoEAcao = nome.split(":");
        if (tipoEAcao[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/" + tipoEAcao[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEAcao[1]);
        }
    }

    @Override
    public void destroy() {

    }
}
