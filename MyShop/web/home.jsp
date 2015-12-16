<%@ page import="model.Utente" %>

<% Utente user = (Utente) session.getAttribute("user");

    if (user == null) {%>

<jsp:forward page="/login.jsp" /> 

<%return;
    } // fatto cosi' per semplicita' di scrittura, lo dovrei gestire meglio con un filtro

%>

<html>

    <head>

        <title>Home page</title>

    </head>

    <body>

        <h2>Home</h2>

        <ul>

            <li><a href="servlet?op=moduloInserimento">Inserisci nuovo ordine</a>

            <li><a href="servlet?op=visualizza">Visualizza Ordini</a>

        </ul>

    </body>

</html>