package javaservlet.gerenciador.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorld",
        description = "Página inicial",
        urlPatterns = {"/hello"})
public class HelloWorldServlet extends HttpServlet {

    @Override protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("""
                <html>
                    <body>
                    Hello World servlet class!!
                    </body>
                </html>
                """);
    }
}
