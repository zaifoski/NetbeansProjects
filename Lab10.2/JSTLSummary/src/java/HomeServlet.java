/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sofia
 */
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    List<Employee> empList = null;    
    
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        empList = new ArrayList<>();    
        
        Employee emp1 = new Employee();
        emp1.setId(1); emp1.setName("Mario");emp1.setRole("Ferrari"); emp1.setStatus("Active");
        
        Employee emp2 = new Employee();
        emp2.setId(2); emp2.setName("Francesco");emp2.setRole("Gasperi"); emp2.setStatus("On leave");
        
        Employee emp3 = new Employee();
        emp3.setId(3); emp3.setName("Maria");emp3.setRole("Matera"); emp3.setStatus("Active");
        
        empList.add(emp1);empList.add(emp2);empList.add(emp3);
                
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("empList", empList);         
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
    }
 

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
