/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import db.DBManager;
import db.Product;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Berta
 */
public class LoadProducts extends HttpServlet {

    private DBManager manager;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        //manager = (DBManager) super.getServletContext().getAttribute("dbmanager");

//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("user") == null) {
//
//            response.sendRedirect(request.getContextPath());
//
//        } else {
//
//            List<Product> products = null;
//            try {
//                processRequest(request, response);
//                products = manager.getProducts();
//            } catch (SQLException ex) {
//                Logger.getLogger(LoadProducts.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            session.setAttribute("products", products);
//
//            //EMETTERE il CODICE HTML della pagine qui
//            //try (PrintWriter out = response.getWriter()) {
//            response.setContentType("text/html;charset=UTF-8");
//            PrintStream ps = new PrintStream(response.getOutputStream());
//            PrintWriter out = new PrintWriter(ps);
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("< meta http - equiv = \"Content-Type\" content = \"text/html; charset=UTF-8\">");
//            out.println("<title>Servlet LoadProducts</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet LoadProducts at " + request.getContextPath() + "</h1>");
//            out.println("<h2>Lista prodotti</h2>");
//            out.println("<table><thead>");
//            out.println("<tr><th>Nome</th><th>Prezzo</th></tr>");
//            for (Product product : products) {
//                out.println("<tr><td>" + request.getParameter("nome") + "</td>");
//                out.println("<td>" + request.getParameter("price") + "</td></tr>");
//            }
//            out.println("</thead><tbody>");
//            out.println("</tbody></table>");
//
//            out.println("</body>");
//            out.println("</html>");
//        }
//        //}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoadProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //manager = (DBManager) super.getServletContext().getAttribute("dbmanager");

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {

            response.sendRedirect(request.getContextPath());

        } else {

            List<Product> products = null;
            try {
                //processRequest(request, response);
                products = manager.getProducts();
            } catch (SQLException ex) {
                Logger.getLogger(LoadProducts.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            session.setAttribute("products", products);

            //EMETTERE il CODICE HTML della pagine qui
            //try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
            PrintStream ps = new PrintStream(response.getOutputStream());
            PrintWriter out = new PrintWriter(ps);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("< meta http - equiv = \"Content-Type\" content = \"text/html; charset=UTF-8\">");
            out.println("<title>Servlet LoadProducts</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadProducts at " + request.getContextPath() + "</h1>");
            out.println("<h2>Lista prodotti</h2>");
            out.println("<table><thead>");
            out.println("<tr><th>Nome</th><th>Prezzo</th></tr>");
            for (Product product : products) {
                out.println("<tr><td>" + request.getParameter("nome") + "</td>");
                out.println("<td>" + request.getParameter("price") + "</td></tr>");
            }
            out.println("</thead><tbody>");
            out.println("</tbody></table>");

            out.println("</body>");
            out.println("</html>");
        
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
