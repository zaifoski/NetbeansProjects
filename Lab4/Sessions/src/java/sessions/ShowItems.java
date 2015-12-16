package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ShowItems", urlPatterns = {"/ShowItems"})

public class ShowItems extends HttpServlet {
    

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html");

        HttpSession session = request.getSession();

        ArrayList previousItems
                = (ArrayList) session.getAttribute("previousItems");

        if (previousItems == null) {

            previousItems = new ArrayList();

            session.setAttribute("previousItems",
                    previousItems);

        }

        String newItem = request.getParameter("newItem");

        PrintWriter out = response.getWriter();

        ////////////////////////////////////////////
        
        out.println("<HTML><TITLE>"+"title"+"</TITLE>" + "<BODY BGCOLOR=\"#FDF5E6\">\n");
        synchronized (previousItems) {

            if (newItem != null) {

                previousItems.add(newItem);

            }

            if (previousItems.size() == 0) {
                out.println("<I>No items</I>");
            } else {

                out.println("<UL>");

                for (int i = 0; i < previousItems.size(); i++) {

                    out.println("<LI>" + (String) previousItems.get(i));

                }

                out.println("</UL>");
                out.println("Per ordinare ancora, click <A HREF=\"" +

 response.encodeUrl("/Sessions/showItems.html") +

 "\">here</A>");
                out.println("</BODY></HTML>");
            }
        }
            
    }
}
