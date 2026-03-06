<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ajouter un Employé</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2 class="mb-4">Inscription d'un nouvel employé</h2>

<form action="employe?action=ajouter" method="post" class="card p-4 shadow-sm">
    <div class="mb-3">
        <label class="form-label">Nom complet :</label>
        <input type="text" name="nom" class="form-control" placeholder="Entrez le nom" required>
    </div>

    <div class="mb-3">
        <label class="form-label">Salaire Mensuel (€) :</label>
        <input type="number" step="0.01" name="salaire" class="form-control" placeholder="0.00" required>
    </div>

    <div class="mb-3">
        <label class="form-label">Employeur (Patron) :</label>
        <select name="idEmployeur" class="form-select" required>
            <c:forEach items="${listeEmployeurs}" var="emp">
                <option value="${emp.id}">${emp.raisonSociale}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit" class="btn btn-success">Enregistrer l'employé</button>
    <a href="index.jsp" class="btn btn-outline-secondary">Annuler</a>
</form>
</body>
</html>