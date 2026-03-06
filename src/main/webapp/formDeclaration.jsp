<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Nouvelle Déclaration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2>Nouvelle Déclaration Mensuelle</h2>

<%-- Affichage d'un message d'erreur si le DAO a détecté un doublon --%>
<c:if test="${not empty erreur}">
    <div class="alert alert-danger">${erreur}</div>
</c:if>

<form action="declaration" method="post" class="mt-4">
    <div class="mb-3">
        <label class="form-label">Entreprise (Employeur) :</label>
        <select name="idEmployeur" class="form-select" required>
            <c:forEach items="${listeEmployeurs}" var="emp">
                <option value="${emp.id}">${emp.raisonSociale}</option>
            </c:forEach>
        </select>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label">Mois (1-12) :</label>
            <input type="number" name="mois" min="1" max="12" class="form-control" placeholder="ex: 03" required>
        </div>
        <div class="col-md-6 mb-3">
            <label class="form-label">Année :</label>
            <input type="number" name="annee" value="2026" class="form-control" required>
        </div>
    </div>

    <button type="submit" class="btn btn-success">Enregistrer et Calculer les Cotisations</button>
    <a href="index.jsp" class="btn btn-secondary">Annuler</a>
</form>
</body>
</html>