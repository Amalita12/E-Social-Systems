<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Droits de l'Assuré</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<div class="card shadow">
    <div class="card-header bg-primary text-white">
        <h3>Dossier Social : ${assure.nom}</h3>
    </div>
    <div class="card-body">
        <p><strong>Salaire Mensuel :</strong> ${assure.salaireMensuel} €</p>
        <hr>
        <div class="row">
            <div class="col-md-6">
                <div class="alert alert-info">
                    <h5>Mois validés</h5>
                    <h2>${assure.nbMoisDeclares}</h2>
                </div>
            </div>
            <div class="col-md-6">
                <div class="alert alert-success">
                    <h5>Total des Cotisations</h5>
                    <h2>${assure.totalCotisations} €</h2>
                </div>
            </div>
        </div>
    </div>
    <div class="card-footer">
        <a href="employeur?action=list" class="btn btn-secondary">Retour aux entreprises</a>
    </div>
</div>
</body>
</html>