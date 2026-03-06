<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Liste des Employeurs</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2 class="mb-4">Liste des Entreprises</h2>

<table class="table table-bordered table-hover">
    <thead class="table-primary">
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
            <td>
                <a href="employeur?action=details&id=${emp.id}" class="btn btn-sm btn-info">Voir détails</a>
                <a href="formEmploye.jsp" class="btn btn-sm btn-info">Voir détails</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="mt-3">
    <a href="ajouterEmployeur.jsp" class="btn btn-sm btn-info">ajouter Emloyeurs</a>
    <a href="index.jsp" class="btn btn-secondary">Retour à l'accueil</a>
</div>
</body>
</html>
