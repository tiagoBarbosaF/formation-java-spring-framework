package javaservlet.gerenciador;

import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "NovaEmpresaServlet", value = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
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
        resp.sendRedirect("listaEmpresas");

//        req.setAttribute("empresa", empresa.getNome());
//        RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//        rd.forward(req, resp);
    }
}
