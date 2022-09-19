package javaservlet.gerenciador.actions;

import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditaEmpresa implements Acao{

    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Editando empresa na nova classe");
        String nomeEmpresa = req.getParameter("nome");
        String paramData = req.getParameter("data");
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Date dataAbertura;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramData);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaId(id);
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        return "redirect:entrada?action=ListaEmpresas";
    }
}
