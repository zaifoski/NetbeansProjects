import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEx1", urlPatterns = {"/ServletEx1"})
public class ServletEx1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlets and forms: Exercise 1</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"pink\">");
        
        //The object "request" received in this method contains all the information
        //associated to the request sent to this Servlet. The method request.getParameter(...)
        //let you access the parameters sent to this Servlet.
        out.println("<b>First name entered:</b> " + request.getParameter("first_name"));
        out.println("<br/>");
        out.println("<b>Last name entered :</b> " + request.getParameter("last_name"));
        
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
