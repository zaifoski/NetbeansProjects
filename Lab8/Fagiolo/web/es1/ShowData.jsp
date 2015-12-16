<%-- 
    Document   : ShowData
    Created on : May 5, 2015, 9:53:08 PM
    Author     : sofia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="Errors.jsp" %>
<!DOCTYPE html>
<html>
    <jsp:useBean id="FormBean" scope="session" class="sessions.FormBean" />

    <jsp:setProperty name="FormBean" property="*" />

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Show Data</h1>
        <!--versione da programmatori-->
        <% out.print(FormBean.getUsername()); %>
        <% out.print(FormBean.getPassword()); %>
        <% out.print(FormBean.getDataNascita()); %>
        <% out.print(FormBean.getNumScarpe());%>
        <!--versione da designer-->
        <jsp:getProperty name="FormBean" property="username" />
        <jsp:getProperty name="FormBean" property="password" />
        <jsp:getProperty name="FormBean" property="dataNascita" />
        <jsp:getProperty name="FormBean" property="numScarpe" />
    </body>
</html>
