<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un Employeur</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            color: #333;
        }

        form {
            max-width: 400px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }

        button {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #444;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }


    </style>
</head>
<body>

<h2>Ajouter un nouvel Employeur</h2>

<form action="employeur" method="post">
    <label for="raisonSociale">Raison Sociale :</label>
    <input type="text" id="raisonSociale" name="raisonSociale" placeholder="Nom de l'entreprise..." required>

    <label for="secteurActivite">Secteur d'activité :</label>
    <input type="text" id="secteurActivite" name="secteurActivite" placeholder="Ex: Informatique..." required>

    <button type="submit">Ajouter l'employeur</button>
</form>

<br>
<a href="employeur?action=list">Retour à la liste</a>

</body>
</html>