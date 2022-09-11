package javaservlet.gerenciador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Empresa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ListaEmpresasServlet", value = "/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
            ServletException {
        Banco banco = new Banco();
        List<Empresa> list = banco.getEmpresas();

        request.setAttribute("listEmpresas", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");
        requestDispatcher.forward(request, response);
    }
}
