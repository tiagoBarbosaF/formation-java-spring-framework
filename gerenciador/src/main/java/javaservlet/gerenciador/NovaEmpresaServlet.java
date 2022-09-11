package javaservlet.gerenciador;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NovaEmpresaServlet", value = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nomeEmpresa = req.getParameter("nome");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1>Empresa " + nomeEmpresa + " cadastrada com sucesso!</h1></body></html>");
        System.out.println("Cadastrando nova empresa " + nomeEmpresa);
    }
}
