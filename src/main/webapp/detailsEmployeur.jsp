<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Détails Employeur</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<div class="card mb-4">
    <div class="card-header bg-dark text-white">
        <h2>Fiche Entreprise : ${employeur.raisonSociale}</h2>
    </div>
    <div class="card-body">
        <p><strong>ID :</strong> ${employeur.id}</p>
        <p><strong>Secteur d'activité :</strong> ${employeur.secteurActivite}</p>
    </div>
</div>

<h3>Liste du Personnel</h3>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom de l'Employé</th>
        <th>Salaire Mensuel</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeur.employes}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.nom}</td>
            <td>${emp.salaireMensuel} €</td>
            <td>
                <a href="employe?action=droits&id=${emp.id}" class="btn btn-sm btn-info">Consulter Droits</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="mt-4">
    <a href="employe?action=nouveau" class="btn btn-primary">Ajouter un employé</a>
    <a href="employeur?action=list" class="btn btn-secondary">Retour à la liste</a>
</div>
</body>
</html>
