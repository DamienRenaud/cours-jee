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
public class Redirect extends HttpServlet {
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
        String context = request.getContextPath();
        String page = request.getParameter("page");
        page = (page == null) ? defaultPage : page;
        String nomPage = "";
        if(page.equals("1")){
            nomPage = "/Page1.html";
            response.sendRedirect(context+nomPage);
        } else if (page.equals("2")) {
            nomPage = "/Page2.html";
            response.sendRedirect(context+nomPage);
        }else{
            response.sendError(404);
        }




    }
}
