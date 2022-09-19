package javaservlet.gerenciador.actions;

import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraEmpresa implements Acao{
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Nova classe mostra empresa");
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();

        Empresa empresa = banco.buscaEmpresaId(id);

        req.setAttribute("empresa", empresa);
        return "forward:formAlteraEmpresa.jsp";
    }
}
