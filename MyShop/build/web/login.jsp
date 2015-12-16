<%-- 
    Document   : login
    Created on : 8-mag-2015, 12.12.40
    Author     : sofia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Login</title>

    </head>

    <body>

        <h2>Login</h2>

        <form action="servlet" method="POST" name="dati">

            <input type="hidden" name="op" value="login">

            <table>

                <tr><td>User:</td><td><input name="account" type="text"></td></tr>

                <tr><td>Password:</td><td><input name="password" type="password"></td></tr>

                <tr><td>&nbsp;</td><td><input type="submit" value="OK"></td></tr>

            </table>

        </form>

    </body>

</html>