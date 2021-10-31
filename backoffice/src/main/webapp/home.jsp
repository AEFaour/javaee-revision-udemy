<%-- 
    Document   : home
    Created on : 29 oct. 2021, 07:17:29
    Author     : anas.faour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Onlinestore - Accueil du back-office</title>
        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/application.js"></script>
    </head>
    <body>
        <h1>OnlineStore - Gestion de la boutique</h1>
        <c:if test="${not empty login}">
        
            Bonjour ${login} (<a href="logout">Déconnexion</a>) </br>
            
        </c:if>
        <a href='add-work-form.html'>Ajouter une oeuvre au catalogue</a> </br>
        <a href="catalogue">Afficher le catalogue</a> </br>
    </body>
</html>
