package javaservlet.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = "/entrada")
public class AutorizacaoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("AutorizacaoFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAction = request.getParameter("action");

        HttpSession session = request.getSession();
        boolean usuarioNaoAutenticado = session.getAttribute("usuarioLogado") == null;
        boolean actionProtegida = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));

        if (actionProtegida && usuarioNaoAutenticado) {
            response.sendRedirect("entrada?action=LoginForm");
        }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
