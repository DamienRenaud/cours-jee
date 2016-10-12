package td.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by renau on 28/09/2016.
 */
public class SessionShow extends HttpServlet {



    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        process(request,response);

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (session != null){
            String val = (String) session.getAttribute("nom");
            out.println("<h1>Session trouvée : "+val+"</h1>");
        }else {
            out.println("<h1>Aucune session trouvée</h1>");
        }





    }
}
