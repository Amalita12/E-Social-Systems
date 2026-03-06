<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Opération réussie</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<div class="alert alert-success text-center">
  <h2 class="alert-heading">Opération effectuée avec succès !</h2>
  <p class="lead">${message}</p>
  <hr>
  <div class="mt-4">
    <a href="index.jsp" class="btn btn-primary">Retour à l'accueil</a>
    <a href="employeur?action=list" class="btn btn-secondary">Voir les employeurs</a>
  </div>
</div>
</body>
</html>