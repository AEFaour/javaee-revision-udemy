/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function() {
    $('input').last().on('click', function () {
        $.ajax({
            url: "http://localhost:8080/firstapp/rest/calculation/somme-et-produit",
            data: $("form").serialize(),
            success: function (resultObject) {
                var message =  "<p>La somme des 2 nombres fournis est <strong>" + resultObject.somme.numerique + " - " +resultObject.somme.texte + "</strong></p>";
                message =  message.concat("<p>Le produit des 2 nombres fournis est <strong>" + resultObject.produit.numerique + " - " +resultObject.produit.texte + "</strong></p>");
                $("form").after(message);
            }
        })
    })
    
})


