<%-- 
    Document   : work-details
    Created on : 30 oct. 2021, 17:22:01
    Author     : anas.faour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details de l'oeuvre</title>
    </head>
    <body>
        <h1>Descriptif de l'oeuvre</h1>
        Titre: ${work.title}
        Année de parution: ${work.release} </br>
        Genre: ${work.genre} </br>
        Artiste: ${work.mainArtist.name} </br>
        Résumé: ${work.summary} </br>
        <form action="addToCart" method="POST">
            <input type="hidden" name="identifiant" value="${work.id}" />
            <input type="submit" value="Ajouter au caddie" />
        </form>

    </body>
</html>
