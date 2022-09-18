package javaservlet.gerenciador.actions;

import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaEmpresas {
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Listando empresas na nova classe");
        Banco banco = new Banco();
        List<Empresa> list = banco.getEmpresas();

        req.setAttribute("empresas", list);
        RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas.jsp");
        rd.forward(req, resp);
    }
}
