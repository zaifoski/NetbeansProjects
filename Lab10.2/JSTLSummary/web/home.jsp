<%-- 
    Document   : home
    Created on : 25-mag-2015, 0.04.10
    Author     : sofia
--%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP home titolo</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
            <table>
                <tr>
                    <td>
                        ID
                    </td>
                    <td>
                        NAME
                    </td>
                    <td>
                        ROLE
                    </td>
                    <td>
                        STATUS
                    </td>
                </tr>
            <c:forEach items="${requestScope.empList}" var="emp">
                <!--Place here the code to create each row of your table-->
                <tr>
                    <!--This is an example of how to access to the values in each iteration:-->
                    <td>
                        <c:out value="${emp.id}"></c:out>
                        </td>
                        <td>
                        <c:out value="${emp.name}"></c:out>
                        </td>
                        <td>
                        <c:out value="${emp.role}"></c:out>
                        </td>
                        <td>
                        <c:out value="${emp.status}"></c:out>
                        </td>
                    </tr>
            </c:forEach>
        </table>

        <c:set var="employeeCount" value="3" scope="request"></c:set>
        Number of employees: <c:out value="${requestScope.employeeCount }" >
        </c:out>
        <c:import url="footer.jsp"></c:import>
    </body>
</html>
