<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>E-Social - Gestion des Déclarations</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<div class="jumbotron">
    <h1 class="display-4">Bienvenue sur E-Social</h1>
    <p class="lead">Système de gestion des cotisations et déclarations sociales.</p>
    <hr class="my-4">
</div>

<div class="row">
    <div class="col-md-4">
        <div class="card h-100">
            <div class="card-body">
                <h5 class="card-title">Employeurs</h5>
                <p class="card-text">Gérer la liste des entreprises et consulter leurs employés.</p>
                <a href="employeur?action=list" class="btn btn-primary">Accéder</a>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="card h-100">
            <div class="card-body">
                <h5 class="card-title">Employés</h5>
                <p class="card-text">Inscrire un nouvel employé dans le système.</p>
                <a href="employe?action=nouveau" class="btn btn-primary">Ajouter</a>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="card h-100">
            <div class="card-body">
                <h5 class="card-title">Déclarations</h5>
                <p class="card-text">Effectuer la déclaration mensuelle des salaires.</p>
                <a href="declaration" class="btn btn-success">Nouvelle Déclaration</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>