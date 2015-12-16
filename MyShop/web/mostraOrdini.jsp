<%@ page import="model.Ordine"%>

<%@ page import="model.Utente"%>

<% Utente user = (Utente) session.getAttribute("user");

    if (user == null) {%>

<jsp:forward page="/login.jsp" />

<% return;
    }%>

<% java.util.Iterator iterator = Ordine.load().iterator();

    Ordine ordine = null; %>

<html>

    <head>

        <title>Ordini</title>

    </head>

    <body>

        <h2>Visualizza Ordini</h2>

        <table>

            <tr><td>Progressivo</td><td>Descrizione</td></tr>

            <% while (iterator.hasNext()) {

        ordine = (Ordine) iterator.next();%>

            <tr><td><a href="servlet?op=mostra&progressivo=<%=""+ordine.getProgressivo()%>"><%="" + ordine.getProgressivo()%></a></td>

                <td><%=ordine.getDescrizione()%></td></tr>

            <%}%>

        </table>

        <a href="servlet?op=moduloInserimento">Inserisci ordine</a>

    </body>

</html>