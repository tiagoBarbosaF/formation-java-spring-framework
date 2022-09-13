package javaservlet.gerenciador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
public class HelloWorld extends HttpServlet {
    @Override protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("""
                <html>
                    <body>
                    Hello World servlet class!!
                    </body>
                </html>
                """);

        System.out.println("Testing print console class servlet.");
    }
}
