package javaservlet.gerenciador.actions;

import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovaEmpresa implements Acao{
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeEmpresa = req.getParameter("nome");
        String dataEmpresa = req.getParameter("data");
        Date dataAbertura;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(dataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }
        PrintWriter out = resp.getWriter();

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        Banco banco = new Banco();
        banco.adicionaEmpresa(empresa);

        req.setAttribute("empresa", empresa.getNome());
        return "redirect:entrada?action=ListaEmpresas";
    }
}
