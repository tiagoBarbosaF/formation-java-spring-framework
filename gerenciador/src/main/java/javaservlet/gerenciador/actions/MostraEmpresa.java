package javaservlet.gerenciador.actions;

import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraEmpresa {
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Nova classe mostra empresa");
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();

        Empresa empresa = banco.buscaEmpresaId(id);

        req.setAttribute("empresa", empresa);
        RequestDispatcher rd = req.getRequestDispatcher("/formAlteraEmpresa.jsp");
        rd.forward(req, resp);
    }
}
