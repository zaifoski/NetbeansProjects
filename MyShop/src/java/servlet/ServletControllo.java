/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import javax.servlet.http.HttpServlet;

/**
 *
 * @author sofia
 */
public class ServletControllo extends HttpServlet {

    public void init(...) { // se servono inizializzazioni particolari

        super.init(
    

    ...);

 // creazione e inizializzazione oggetti con scope application 

 }

 public void doGet(request, response) {
        ...

        String op = request.getParameter("op");

        HttpSession session = request.getSession(true);

        Utente u = (Utente) session.getAttribute("user");

        if ("login".equals(op) || op == null) {

            u = new Utente(request.getParameter("account"));

            if (u == null || !u.checkPassword(request.getParameter("password"))) {
                forward(request, response, "/login.jsp");
            } else {

                session.setAttribute("user", u);

                forward(request, response, "/home.jsp");

            }

            return;

        }


        if ("inserimento".equals(op)) // blocco per una action del controller
        {

            Ordine nuovo = new Ordine();

            try {

                nuovo.setProgressivo(Integer.parseInt(request.getParameter("progressivo")));

            } catch (Exception e) {

                forward(request, response, "/inputError.jsp");

                return;

            }

            nuovo.setDescrizione(request.getParameter("descrizione"));

            nuovo.insert();

            forward(request, response, "/home.jsp");

        } else if ("moduloInserimento".equals(op)) {

            forward(request, response, "/moduloInserimento.jsp");

        }

        Servlet Controller

 else if ("mostra".equals(op))

 {

 Ordine ordine=null;

 try

 {

 

ordine=Ordine.load(Integer.parseInt(request.getParameter("progressivo")));

 }

 catch (Exception e)

 {

 forward(request,response,"/inputError.jsp");

 return;

 }

 request.setAttribute("ordine",ordine);

 forward(request,response,"/mostra.jsp");

 }

 else if ("visualizza".equals(op))

 {

 forward(request,response,"/mostraOrdini.jsp");

 }
        //else eventuasli altri casi da finire 

        .......

    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();

        RequestDispatcher rd = sc.getRequestDispatcher(page);

        rd.forward(request, response);

    }

}
