package servlet;

import db.DBManager;
import db.User;
import java.io.IOException;
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
 * @author @version 1.0
 */
public class ServletRegistrati extends HttpServlet {

    private DBManager manager;

    @Override
    public void init() throws ServletException {
        // inizializza il DBManager dagli attributi di Application
        this.manager = (DBManager) super.getServletContext().getAttribute("dbmanager");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // controllo nel DB se esiste un utente con lo stesso username + password
        User user;
        try {

            manager.registrati(username, password);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        String pathInfo;
        if (req.getPathInfo() != null) {
            pathInfo = req.getPathInfo();
        } else {
            pathInfo = "";
        }
        resp.sendRedirect(req.getContextPath() + pathInfo);
    }

}
