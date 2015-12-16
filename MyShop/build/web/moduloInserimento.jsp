<%@ page import="model.Utente" %>

<% Utente user = (Utente) session.getAttribute("user");

    if (user == null) {%>

<jsp:forward page="/login.jsp" /> 

<%return;
    }%>

<html>

    <head>

        <title>Ordini</title>

    </head>

    <body>

        <h2>Inserimento Ordine</h2>

        <form action="servlet" method="POST" name="dati">

            <input type=hidden name="op" value="inserimento">

            <table>

                <tr><td>Progressivo:</td><td><input name="progressivo" type="text"></td></tr>

                <tr><td>Descrizione:</td><td><input name="descrizione" type="text"></td></tr>

                <tr><td>&nbsp;</td><td><input type="submit" value="OK"></td></tr>

            </table>

        </form>

    </body>

</html>