package td.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by renau on 28/09/2016.
 */
public class SessionInit extends HttpServlet {

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
        HttpSession session = request.getSession();
        session.setAttribute("nom","toto");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Session initialisée</h1>");
//        Cookie cookie = new Cookie("session",session.getId());
//        response.addCookie(cookie);
    }
}
