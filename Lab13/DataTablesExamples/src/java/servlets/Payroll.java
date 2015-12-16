/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Web programming
 */
@WebServlet(name = "Payroll", urlPatterns = {"/Payroll"})
public class Payroll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* In this Servlet, we read the whole data (JSON) from a text file. In practice,
         * what you typically need to do inside this servlet is to implement a logic to do
         * the "pagination" of the of the data. Also, you need to implement the logic
         * for searching tuples in the "Search" textbox of the page.
         * You can find examples of how to do this by going to:
         * http://datatables.net/examples/server_side/simple.html
         */
        
        response.setContentType("application/json");       
        System.out.println(request.getQueryString());
        BufferedReader br = new BufferedReader(new FileReader(this.getServletContext().getRealPath("/data/arrays.txt")));
        PrintWriter out = response.getWriter();
        
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
               out.print(line);
               line = br.readLine();
            }
        } finally {
            br.close();
        }
        
        out.flush();        
    }
}
