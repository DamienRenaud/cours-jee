package td.servlet;

import javax.servlet.RequestDispatcher;
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
public class Forward extends HttpServlet {
    private String defaultPage;



    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        defaultPage = config.getInitParameter("page");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        process(request,response);

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String page = request.getParameter("page");
        page = (page == null) ? defaultPage : page;
        String nomPage = "";
        RequestDispatcher rd;
//        rd = request.getServletContext().getNamedDispatcher("ViewServlet");
//        getServletContext().setAttribute("page",page);
        if(page.equals("1")){
            nomPage = "/Page1.html";
            rd = request.getRequestDispatcher(nomPage);
            rd.forward(request,response);
        } else if (page.equals("2")) {
            nomPage = "/Page2.html";
            rd = request.getRequestDispatcher(nomPage);
            rd.forward(request,response);

        }else if(page.equalsIgnoreCase("jsp")){
            request.setAttribute("test","blabla");
            rd = request.getRequestDispatcher("/page1.jsp");
            rd.forward(request,response);
        }
        else{
            response.sendError(404);
        }





    }
}
