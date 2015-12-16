import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEx3", urlPatterns = {"/ServletEx3"})
public class ServletEx3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlets and forms: Exercise 3</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        
        //We get the list of parameter names sent to the Servlet
        Enumeration paramNames = request.getParameterNames();
        
        //We iterate over the list of parameter names
        while(paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            
            out.println("<br/><br/>");
            out.println("<b>" + paramName + ":</b>");
            out.println("<br/><br/>");
            
            //We get the list of parameter values for a given parameter
            String paramValues[] = request.getParameterValues(paramName);
            
            if(paramValues.length == 1){ //If the parameter contains a single value
                
                String paramValue = paramValues[0];
                if(paramValue.length() == 0){
                    out.println("No value");
                }else{
                    out.println(paramValue);
                }                
                
            }else{ //If the parameter contains multiple values
                
                //Read multiple valued data
                for(int i = 0; i < paramValues.length; i++){
                    out.println(paramValues[i]);
                    out.println("<br/>");
                }                
            }            
        }        
        
        out.println("</body>");
        out.println("</html>");
        out.close();   
    }    
}