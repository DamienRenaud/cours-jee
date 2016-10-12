package td.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by renau on 28/09/2016.
 */
public class HelloParam extends HttpServlet {
    private String lang;
    private String nom;



    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        lang = getInitParameter("lang");
        nom = getInitParameter("nom");

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        process(request,response);

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.nom = this.nom == null ? request.getParameter("nom") : this.nom;
        this.lang = this.lang == null ? request.getParameter("lang") : this.lang;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if(lang.equals("fr")){
            out.println("<h1>Bonjour ! "+nom+"</h1>");
        }else {
            out.println("<h1>Hello world !"+nom+" </h1>");
        }
        out.println("<h1>getServletName() : " + getServletName() + "</h1>");
        out.println("<h1>URI : " + request.getRequestURI() + "</h1>");
        out.println("<h1>LANG : " + lang + "</h1>");


    }
}
