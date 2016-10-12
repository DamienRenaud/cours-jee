package td.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by renau on 28/09/2016.
 */
public class HelloConfig extends HttpServlet {

    private String lang;

    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        lang = config.getInitParameter("lang");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        process(request,response);

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if(lang.equals("fr")){
            out.println("<h1>Bonjour ! </h1>");
        }else {
            out.println("<h1>Hello world ! </h1>");
        }
        out.println("<h1>getServletName() : " + getServletName() + "</h1>");
        out.println("<h1>URI : " + request.getRequestURI() + "</h1>");
        out.println("<h1>LANG : " + lang + "</h1>");


    }
}
