<%-- 
    Document   : jspLogin
    Created on : 24-apr-2015, 10.05.59
    Author     : Berta
--%>

<%@ page language="java" contentType="text/html" %> 
<html>
    <head> 
        <title> My eBank </title> 
    <body> 
        <%
            if (request.getParameter("id").equals("pippo") && request.getParameter("pwd").equals("b")) {
                out.println("Vous avez inserer les donnees correctes");
            } else {
                out.println("Attention!!! Vous N'avez pas inserer les donnees correctes");
            }
        %>
        <%--application Scriplet validazione login usare l?oggetto implicito request --%> 
    </body>
</html>
