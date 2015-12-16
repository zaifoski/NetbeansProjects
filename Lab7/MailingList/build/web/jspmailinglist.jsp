<%-- 
    Document   : jspmailinglist
    Created on : 24-apr-2015, 12.26.09
    Author     : Berta
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@ page import="business.*, data.*" %><!--commento--> 

<%

    String firstName = request.getParameter("first_name");// here you need to get the corresponding parameter from the request object
    String lastName = request.getParameter("last_name");// here you need to get the corresponding parameter from the request object
    String emailAddress = request.getParameter("email_address");// here you need to get the corresponding parameter from the request object

    User user = new User(firstName, lastName, emailAddress); //create the User object
    UserIO.addRecord(user, "C:/Users/Berta/Desktop/prove.txt"); //Save the record in the text file

    //String path = application.getRealPath("/WEB-INF");
   
    
    //File file = new File("C:/Users/Berta/Desktop", "prove.txt");
    //
    //OutputStream output = new FileOutputStream(file);
    //UserIO.addRecord(user, "C:/Users/Berta/desktop/prove" path + "/UserEmail.txt");
    //UserIO.addRecord(user, "C:/Users/Berta/Desktop/prove" + "/UserEmail.txt");
    //String dataPath = properties.getProperty("data.path");
    //File file = new File(dataPath, "filename.txt");
    //OutputStream output = new FileOutputStream(file);

    
%> 





<html>
    <head>
        <title></title>
    </head>
    <body>
        <H1> Thanks for joininng our mailing list</h1>
        <p>Here is the information you entered</p>

        <table> 
            <tr>
                <td> First name:</td> <td> <%=firstName%>   </td>
            </tr>
            <tr>
                <td> Last name:</td> <td> <%=lastName%>   </td>
            </tr>
            <tr>
                <td> Email Address:</td> <td> <%=emailAddress%>   </td>
            </tr>

        </table> 
    </body>
</html>