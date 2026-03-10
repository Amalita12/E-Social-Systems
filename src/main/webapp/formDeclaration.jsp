<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Nouvelle Déclaration</title>
    <style>
        body { font-family: sans-serif; margin: 30px; color: #333; }
        .erreur { color: red; border: 1px solid red; padding: 10px; margin-bottom: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; }
        input, select { width: 300px; padding: 8px; border: 1px solid #ccc; }
        button { padding: 10px 15px; cursor: pointer; }
    </style>
</head>
<body>

<h2>Nouvelle Déclaration Mensuelle</h2>

<form action="declaration" method="post">
    <div class="form-group">
        <label>Entreprise :</label>
        <select name="idEmployeur" required>
            <c:forEach items="${listeEmployeurs}" var="emp">
                <option value="${emp.id}">${emp.raisonSociale}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <label>Mois (1-12) :</label>
        <input type="number" name="mois" min="1" max="12" placeholder="ex: 03" required>
    </div>

    <div class="form-group">
        <label>Année :</label>
        <input type="number" name="annee" value="2026" required>
    </div>

    <button type="submit">Enregistrer et Calculer</button>
    <a href="index.jsp">Annuler</a>
</form>

</body>
</html>