<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Ajouter un Employé</title>
    <style>
        body { font-family: sans-serif; margin: 30px; color: #333; }
        .form-bloc { border: 1px solid #ccc; padding: 20px; width: 350px; }
        .input-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; }
        input, select { width: 100%; padding: 8px; border: 1px solid #ccc; }
        button { padding: 10px 15px; cursor: pointer; }
    </style>
</head>
<body>

<h2>Inscription d'un nouvel employé</h2>

<form action="employe?action=ajouter" method="post" class="form-bloc">
    <div class="input-group">
        <label>Nom complet :</label>
        <input type="text" name="nom" required>
    </div>

    <div class="input-group">
        <label>Salaire Mensuel (DH) :</label>
        <input type="number" step="0.01" name="salaire" required>
    </div>

    <div class="input-group">
        <label>Employeur :</label>
        <select name="idEmployeur" required>
            <c:forEach items="${listeEmployeurs}" var="emp">
                <option value="${emp.id}">${emp.raisonSociale}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit">Enregistrer</button>
    <a href="index.jsp">Annuler</a>
</form>

</body>
</html>