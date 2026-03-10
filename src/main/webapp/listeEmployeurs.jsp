<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Liste des Employeurs</title>
    <style>
        body { font-family: sans-serif; margin: 30px; color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #f4f4f4; }
        .actions { display: flex; gap: 10px; }
        a { color: #333; text-decoration: underline; }
    </style>
</head>
<body>

<h2>Liste des Entreprises</h2>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Raison Sociale</th>
        <th>Secteur d'Activité</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listeEmployeurs}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.raisonSociale}</td>
            <td>${emp.secteurActivite}</td>
            <td class="actions">
                <a href="employeur?action=details&id=${emp.id}">Détails</a>
                <a href="formEmploye.jsp">Ajouter Employé</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div style="margin-top: 20px;">
    <a href="ajouterEmployeur.jsp">Ajouter un employeur</a> |
    <a href="index.jsp">Retour à l'accueil</a>
</div>

</body>
</html>