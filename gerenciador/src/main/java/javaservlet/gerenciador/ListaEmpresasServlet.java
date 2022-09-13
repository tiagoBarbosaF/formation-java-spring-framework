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
import java.util.List;

@WebServlet(name = "ListaEmpresasServlet", value = "/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
            ServletException {
        Banco banco = new Banco();
        List<Empresa> list = banco.getEmpresas();

        request.setAttribute("empresas", list);
        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
        rd.forward(request, response);
    }
}
