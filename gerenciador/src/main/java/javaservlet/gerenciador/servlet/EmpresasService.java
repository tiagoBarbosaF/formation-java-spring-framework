package javaservlet.gerenciador.servlet;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import javaservlet.gerenciador.model.Banco;
import javaservlet.gerenciador.model.Empresa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpresasService", value = "/empresas")
public class EmpresasService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Empresa> empresas = new Banco().getEmpresas();
        String accept = req.getHeader("Accept");

        if (accept.contains("xml")) {
            // Utilizando a biblioteca XStream somente por motivos didáticos, evite usa-la por motivos de vulnerabilidade.
            XStream xStream = new XStream();
            xStream.alias("empresa", Empresa.class);
            resp.setContentType("application/xml");
            String xml = xStream.toXML(empresas);
            resp.getWriter().println(xml);
        } else if (accept.endsWith("json")) {
            Gson gson = new Gson();
            resp.setContentType("application/json");
            String json = gson.toJson(empresas);
            resp.getWriter().print(json);
        } else {
            resp.setContentType("application/json");
            resp.getWriter().print("{'message': 'no content'}");
        }

    }
}
