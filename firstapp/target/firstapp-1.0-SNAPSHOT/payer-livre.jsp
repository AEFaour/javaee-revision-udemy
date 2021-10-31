<%-- 
    Document   : payer-livre
    Created on : 30 oct. 2021, 08:35:16
    Author     : anas.faour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livre payé</title>
    </head>
    <body>
        Paiement effectué avec le numéro de carte : <%=request.getParameter("numeroCarte")  %> <br/>
        Liste des livres payés : </br>
        <c:forEach items="${listelivres}" var="livre">
             Le livre payé est le livre numéro ${livre.numeroLivre} <br/>
        </c:forEach>
    </body>
</html>
