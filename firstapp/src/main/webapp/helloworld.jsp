<%-- 
    Document   : helloworld
    Created on : 29 oct. 2021, 05:25:16
    Author     : anas.faour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="hw.aef.firstappcore.Personne"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!!!</h1>
        <%
            Personne personne = new Personne("Alexandra", "Beraldin");
        %>
        ${sessionScope.qqchose}
        Bonjour <%=personne.getFullName()%></br>

    </body>
</html>
