package javaservlet.gerenciador.actions;

import javaservlet.gerenciador.model.Banco;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveEmpresa implements Acao{
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("removendo empresa pela nova classe");
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        banco.removeEmpresa(id);

        return "redirect:entrada?action=ListaEmpresas";
    }
}
