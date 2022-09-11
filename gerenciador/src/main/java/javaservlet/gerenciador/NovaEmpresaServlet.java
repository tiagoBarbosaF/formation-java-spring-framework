package javaservlet.gerenciador;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Empresa;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NovaEmpresaServlet", value = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nomeEmpresa = req.getParameter("nome");
        PrintWriter out = resp.getWriter();

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);

        Banco banco = new Banco();
        banco.adicionaEmpresa(empresa);

        System.out.println("Cadastrando nova empresa " + nomeEmpresa);
        banco.getEmpresas().forEach(System.out::println);
        out.println("<html><body><h1>Empresa " + nomeEmpresa + " cadastrada com sucesso!</h1></body></html>");
    }
}
