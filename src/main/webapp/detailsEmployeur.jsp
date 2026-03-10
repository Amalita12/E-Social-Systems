<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Détails Employeur</title>
    <style>
        body { font-family: sans-serif; margin: 30px; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        th, td { border: 1px solid black; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        .bloc-info { border: 1px solid black; padding: 15px; margin-bottom: 20px; width: 300px; }
    </style>
</head>
<body>

<h2>Fiche Entreprise : ${employeur.raisonSociale}</h2>

<div class="bloc-info">
    <p><strong>ID :</strong> ${employeur.id}</p>
    <p><strong>Secteur :</strong> ${employeur.secteurActivite}</p>
</div>

<h3>Liste du Personnel</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Salaire</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeur.employes}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.nom}</td>
            <td>${emp.salaireMensuel} MAD</td>
            <td>
                <a href="employe?action=droits&id=${emp.id}">Consulter Droits</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="employe?action=nouveau">Ajouter un employé</a> |
<a href="employeur?action=list">Retour à la liste</a>

</body>
</html>