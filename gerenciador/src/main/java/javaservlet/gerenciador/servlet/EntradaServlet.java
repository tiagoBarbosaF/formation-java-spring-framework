package javaservlet.gerenciador.servlet;

import javaservlet.gerenciador.actions.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EntradaServlet", value = "/entrada")
public class EntradaServlet extends HttpServlet {
    @Override protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String paramAction = req.getParameter("action");

        if (paramAction.equals("ListaEmpresas")) {
            ListaEmpresas listaEmpresas = new ListaEmpresas();
            listaEmpresas.execute(req, resp);
        } else if (paramAction.equals("MostraEmpresa")) {
            MostraEmpresa mostraEmpresa = new MostraEmpresa();
            mostraEmpresa.execute(req, resp);
        } else if (paramAction.equals("EditaEmpresa")) {
            EditaEmpresa editaEmpresa = new EditaEmpresa();
            editaEmpresa.execute(req, resp);
        } else if (paramAction.equals("RemoveEmpresa")) {
            RemoveEmpresa removeEmpresa = new RemoveEmpresa();
            removeEmpresa.execute(req,resp);
        } else if (paramAction.equals("NovaEmpresa")) {
            NovaEmpresa novaEmpresa = new NovaEmpresa();
            novaEmpresa.execute(req,resp);
        }
    }
}
