package javaservlet.gerenciador.servlet;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/entrada")
public class MonitorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("MonitorFilter");
        long begin = System.currentTimeMillis();

        String action = request.getParameter("action");
        chain.doFilter(request, response);

        long end = System.currentTimeMillis();
        long result = end - begin;
        System.out.printf("Tempo de execução da ação: %s -> %d%n", action, result);
    }

    @Override
    public void destroy() {

    }
}
