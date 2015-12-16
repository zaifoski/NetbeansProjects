import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*;

/** Sets six cookies: three that apply only to the current session 

* (regardless of how long that session lasts) and three that persist for an hour 

* (regardless of whether the browser is restarted).

*/

public class SetCookies extends HttpServlet {

 public void doGet(HttpServletRequest request,

HttpServletResponse response) 

throws ServletException, IOException {

 for(int i=0; i<3; i++) {

 // Default maxAge is -1, indicating cookie applies only to current browsing session.

 Cookie cookie = new Cookie("Session-Cookie-" + i, "Cookie-Value-S" + i);

cookie.setMaxAge(-1);

 response.addCookie(cookie);
 cookie = new Cookie("Persistent-Cookie-" + i,"Cookie-Value-P" + i);

 // Cookie is valid for an hour, regardless of whether

 // user quits browser, reboots computer, or whatever.

 cookie.setMaxAge(3600);

 response.addCookie(cookie);

 } 

 response.setContentType("text/html");

 PrintWriter out = response.getWriter();

 String title = "Setting Cookies";

 out.println("<HTML><HEAD><TITLE>" +title+ "</TITLE></HEAD>" +

 "<BODY BGCOLOR=\"#FDF5E6\">\n" +"<H1 ALIGN=\"CENTER\">" 

+ title + "</H1>\n" + "There are six cookies associated with this page.\n" + "</BODY></HTML>");
 }

}
