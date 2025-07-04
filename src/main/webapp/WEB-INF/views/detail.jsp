<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>${livre.titre} | Détails</title>

    <!-- Bootstrap + ton style perso -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>

    <header>
        <h1>Grande Bibliothèque </h1>
        <p>Explorez. Découvrez. Apprenez.</p>
    </header>

    <nav>
        <a href="#">🏠 Accueil</a>
        <a href="livres">📕 Livres</a>
        <a href="#">🔌 Connexion</a>
        <a href="#">☎️ Contact</a>
    </nav>

    <%-- CONTENU PRINCIPAL --%>
    <div class="container my-4">

        <div class="card shadow-sm">
            <div class="card-body">
                <h2 class="card-title">${livre.titre}</h2>
                <h5 class="card-subtitle mb-3 text-muted">${livre.auteur}</h5>

                <ul class="list-group list-group-flush mb-3">
                    <li class="list-group-item"><strong>Édition :</strong> ${livre.editionLivre}</li>
                    <li class="list-group-item"><strong>ISBN :</strong> ${livre.isbn}</li>
                </ul>

                <a href="${pageContext.request.contextPath}/livres"
                   class="btn btn-link mt-3">← Retour au catalogue</a>
            </div>
        </div>

    </div>

    <footer>
        &copy; 2025 Bibliothèque - Tous droits réservés
    </footer>

</body>
</html>
