<%-- 
    Document   : index
    Created on : 20-lug-2015, 18.32.01
    Author     : sofia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Cinema7</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <p>${message}</p>
            
            <p>${session.getAttribute(user)}</p>

            <form method="post" action="ServletLogin">
                login:
                username: <input type="text" name="username">
                password: <input type="text" name="password">
                <input type="submit" value="login">
            </form>
            <form method="post" action="ServletLogout">
                logout:
                <input type="submit" value="logout">
            </form>
            <form method="post" action="ServletRegistrati">
                registrazione:
                username: <input type="text" name="username">
                password: <input type="text" name="password">
                <input type="submit" value="registrati">
            </form>
            <form method="post" action="ServletCambioPassword">
                cambio password:
                username: <input type="text" name="email">
                <input type="submit" value="cambio pass">
            </form>
        </div>
    </body>
</html>

