<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dossier Assuré</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }

        .cadre-info {
            border: 1px solid black;
            padding: 15px;
            width: 250px;
            margin-top: 10px;
        }

        .lien-retour { margin-top: 20px; display: block; }
    </style>
</head>
<body>

<h2>Dossier Social : ${assure.nom}</h2>

<p>Salaire Mensuel : <strong>${assure.salaireMensuel} MAD</strong></p>

<div class="cadre-info">
    <p>Mois validés : <strong>${assure.nbMoisDeclares}</strong></p>
    <p>Total Cotisations : <strong>${assure.totalCotisations} MAD</strong></p>
</div>

<a href="employeur?action=list" class="lien-retour">Retour à la liste</a>

</body>
</html>