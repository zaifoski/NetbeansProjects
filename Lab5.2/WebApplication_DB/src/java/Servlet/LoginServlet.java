package servlet;

import db.DBManager;
import db.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 *
 * @author
 * @version 1.0
 */

public class LoginServlet extends HttpServlet {
    private DBManager manager;
    
    @Override
    public void init() throws ServletException {
        // inizializza il DBManager dagli attributi di Application
        this.manager = (DBManager)super.getServletContext().getAttribute("dbmanager");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // controllo nel DB se esiste un utente con lo stesso username + password

        User user;
        try {

            user = manager.authenticate(username, password);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        // se non esiste, ridirigo verso pagina di login con messaggio di errore
        if (user == null) {
            // metto il messaggio di errore come attributo di Request, così nel JSP si vede il messaggio

            /*req.setAttribute("message", "Username/password non esistente !");

            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.forward(req, resp);*/
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.print("username or password error!");

            RequestDispatcher rd = req.getRequestDispatcher("index.html");

            rd.include(req, resp);
            return;

        } else {

            // imposto l'utente connesso come attributo di sessione
            // per adesso e' solo un oggetto String con il nome dell'utente, ma posso metterci anche un oggetto User
            // con, ad esempio, il timestamp di login

            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);

            // mando un redirect alla servlet che carica i prodotti

            resp.sendRedirect(req.getContextPath() + "/LoadProducts");
        }
    }

}
