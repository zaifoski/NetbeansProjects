<%-- 
    Document   : random
    Created on : 24-apr-2015, 9.21.36
    Author     : Berta
--%>

<%@page import="org.apache.coyote.http11.Constants"%>
<%@ page language="java" contentType="text/html" %> 
<%@ page import="java.util.*" %> 
<%! int randomColor( ) { Random rand = new Random(); return rand.nextInt(255) ; } %> 
<html> 
<head> 
<title>Random Color</title> 
</head> 
<body bgcolor="white"> 
<h1>Random Color</h1> 
<table bgcolor = "rgb(<%=randomColor()%>, <%=randomColor()%>, <%=randomColor()%>)"> 
        <tr><td width="100" height="100">&nbsp;</td></tr> 
</table> 
</body> 
</html>