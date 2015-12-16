<%-- 
    Document   : error
    Created on : 25-mag-2015, 0.21.55
    Author     : sofia
--%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h2>Error in processing the request:</h2><br>
       
        Error message: <%= exception %>
            
    </body>
</html>
