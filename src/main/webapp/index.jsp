<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>E-Social - Accueil</title>
    <style>
        body { font-family: sans-serif; margin: 40px; color: #333; }
        .header { margin-bottom: 30px; border-bottom: 1px solid #ccc; padding-bottom: 20px; }
        .menu-container { display: flex; gap: 20px; }
        .menu-card { border: 1px solid #ccc; padding: 20px; width: 250px; }
        h5 { margin-top: 0; }
        a { display: inline-block; margin-top: 10px; padding: 5px 10px; border: 1px solid #ffffff; text-decoration: none; color: #fff; background-color: #bf73fb; border-radius: 10px; }
    </style>
</head>
<body>

<div class="header">
    <h1>Bienvenue sur E-Social</h1>
    <p>Système de gestion des cotisations et déclarations sociales.</p>
</div>

<div class="menu-container">
    <div class="menu-card">
        <h5>Employeurs</h5>
        <p>Gérer la liste des entreprises et leurs employés.</p>
        <a href="employeur?action=list">Accéder</a>
    </div>

    <div class="menu-card">
        <h5>Employés</h5>
        <p>Inscrire un nouvel employé dans le système.</p>
        <a href="employe?action=nouveau">Ajouter</a>
    </div>

    <div class="menu-card">
        <h5>Déclarations</h5>
        <p>Effectuer la déclaration mensuelle des salaires.</p>
        <a href="declaration">Nouvelle Déclaration</a>
    </div>
</div>

</body>
</html>