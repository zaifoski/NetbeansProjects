import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEx2", urlPatterns = {"/ServletEx2"})
public class ServletEx2 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlets and forms: Exercise 2</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
                
        out.println("<b>Picked subjects:</b><br/><br/>");
        out.println("<b>Maths flag:</b> " + request.getParameter("maths"));
        out.println("<br/>");
        out.println("<b>Physics flag:</b> " + request.getParameter("physics"));
        out.println("<br/>");
        out.println("<b>Chemistry flag:</b> " + request.getParameter("chemistry"));
        
        out.println("</body>");
        out.println("</html>");
        out.close();                
    }
}