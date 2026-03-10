<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Opération réussie</title>
  <style>
    body { font-family: sans-serif; margin: 40px; color: #333; }
    .message-box { border: 1px solid #28a745; padding: 20px; background-color: #e9f7ef; text-align: center; }
    h2 { color: #28a745; margin-top: 0; }
    .nav-links { margin-top: 20px; }
    a { margin: 0 10px; color: #333; text-decoration: underline; }
  </style>
</head>
<body>

<div class="message-box">
  <h2>Opération effectuée avec succès !</h2>
  <p>${message}</p>

  <div class="nav-links">
    <a href="index.jsp">Retour à l'accueil</a> |
    <a href="employeur?action=list">Voir les employeurs</a>
  </div>
</div>

</body>
</html>