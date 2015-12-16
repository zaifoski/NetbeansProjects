<%-- 
    Document   : Errors
    Created on : May 5, 2015, 10:56:23 PM
    Author     : sofia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error World!</h1>
        <%=exception.toString() %>
    </body>
</html>
