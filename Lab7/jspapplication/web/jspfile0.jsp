<%-- 
    Document   : jspfile0
    Created on : 21-apr-2015, 16.50.37
    Author     : Berta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Ciao Sofia sei bellissima =)</h1>

        <%
            try {
                int a = Integer.parseInt(request.getParameter("numero1"));
                int b = Integer.parseInt(request.getParameter("numero2"));
        %>
        <ol>
            <li>somma: <%=a + b%></li>
            <li>differenza:<%=a - b%></li>
            <li>prodotto:<%=a * b%></li>
            <li>quoziente:<% if (b == 0) {%> f**k <%} else{%> <%=a / b%> <%}%></li>
        </ol>

        <%
        } catch (Exception e) {
            out.println("<p>buuuuu</p>");
        %>
        <meta HTTP-EQUIV="REFRESH" content="2; url=index.html">
        <%
            } finally {
            }
            ;
        %>


    </body>
</html>
