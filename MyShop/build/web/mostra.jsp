<%@ page import="model.Ordine"%>

<%@ page import="model.Utente"%>

<% Utente user = (Utente) session.getAttribute("user");

    if (user == null) {%>

<jsp:forward page="/login.jsp" /> 

<%return;
    }%>

<% Ordine ordine = (Ordine) request.getAttribute("ordine");%>

<html>

    <head>

        <title>Ordini</title>

    </head>

    <body>

        <h2>Visualizza Ordine</h2>

        <table>

            <tr><td>Progressivo:</td><td><%="" + ordine.getProgressivo()%></td></tr>

            <tr><td>Descrizione:</td><td><%=ordine.getDescrizione()%></td></tr>

        </table>

           <a href="servlet?op=modifica&progressivo=<%="" + ordine.getProgressivo()%>">Modifica questo ordine</a>

    </body>

</html>