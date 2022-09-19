package javaservlet.gerenciador.actions;

import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListaEmpresas implements Acao{
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Listando empresas na nova classe");
        Banco banco = new Banco();
        List<Empresa> list = banco.getEmpresas();

        req.setAttribute("empresas", list);

        return "forward:listaEmpresas.jsp";
    }
}
