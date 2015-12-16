<%-- 
    Document   : carts
    Created on : May 5, 2015, 10:18:48 PM
    Author     : sofia
--%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

    <html>

        <jsp:useBean id="cart" scope="session" class="sessions.DummyCart" />

        <jsp:setProperty name="cart" property="*" />
                
        <% cart.processRequest(request); %>

        <FONT size = 5 COLOR="#CC0000">

        <br> You have the following items in your cart:

        <ol>

            <%

                Vector items = cart.getV();

                for (Object o : items) {

            %>

            <li>

                <% out.println(o); %>

                <% }%>

        </ol>

        </FONT>

        <a href="es2.html">aggiungi altri </a>

    </body>
</html>
