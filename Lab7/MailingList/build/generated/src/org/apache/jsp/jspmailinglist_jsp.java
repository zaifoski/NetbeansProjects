package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
import business.*;
import data.*;

public final class jspmailinglist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--commento--> \n");
      out.write("\n");


    String firstName = request.getParameter("first_name");// here you need to get the corresponding parameter from the request object
    String lastName = request.getParameter("last_name");// here you need to get the corresponding parameter from the request object
    String emailAddress = request.getParameter("email_address");// here you need to get the corresponding parameter from the request object

    User user = new User(firstName, lastName, emailAddress); //create the User object
    //UserIO.addRecord(user, "D:/../WEB-INF/etc/UserEmail.txt"); //Save the record in the text file

    //String path = application.getRealPath("/WEB-INF");
   
    
    File file = new File("C:/Users/Berta/desktop/prove", "filename.txt");
    //
     
     OutputStream output = new FileOutputStream(file);
    //UserIO.addRecord(user, "C:/Users/Berta/desktop/prove" path + "/UserEmail.txt");
    UserIO.addRecord(user, "C:/Users/Berta/Desktop/prove" + "/UserEmail.txt");
//String dataPath = properties.getProperty("data.path");
//File file = new File(dataPath, "filename.txt");
//OutputStream output = new FileOutputStream(file);

    

      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title></title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <H1> Thanks for joininng our mailing list</h1>\n");
      out.write("        <p>Here is the information you entered</p>\n");
      out.write("\n");
      out.write("        <table> \n");
      out.write("            <tr>\n");
      out.write("                <td> First name:</td> <td> ");
      out.print(firstName);
      out.write("   </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td> Last name:</td> <td> ");
      out.print(lastName);
      out.write("   </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td> Email Address:</td> <td> ");
      out.print(emailAddress);
      out.write("   </td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("        </table> \n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
