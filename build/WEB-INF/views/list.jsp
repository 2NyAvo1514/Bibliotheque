<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Catalogue des livres</title>

    <!-- Bootstrap + ton style perso -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>

    <%-- ==== ENTÊTE & NAV (copié depuis l’accueil) ==== --%>
    <header>
        <h1>Bibliothèque Communale</h1>
        <p>Explorez. Découvrez. Apprenez.</p>
    </header>

    <nav>
        <a href="${pageContext.request.contextPath}/">🏠 Accueil</a>
        <a href="${pageContext.request.contextPath}/livres">📇 Catalogue</a>
        <a href="#">🔌 Connexion</a>
        <a href="#">☎️ Contact</a>
    </nav>

    <%-- ==== CONTENU PRINCIPAL ==== --%>
    <div class="container my-4">
        <h2 class="mb-3">Catalogue</h2>

        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle">
                <thead class="table-dark">
                    <tr>
                        <th>Titre</th>
                        <th>Auteur</th>
                        <th>Édition</th>
                        <th>ISBN</th>
                        <th class="text-center">Détails</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${livres}" var="livre">
                        <tr>
                            <td>${livre.titre}</td>
                            <td>${livre.auteur}</td>
                            <td>${livre.editionLivre}</td>
                            <td>${livre.isbn}</td>
                            <td class="text-center">
                                <a class="btn btn-sm btn-primary"
                                   href="${pageContext.request.contextPath}/livres/${livre.idLivre}">
                                   Voir
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <a href="${pageContext.request.contextPath}/livres/new" class="btn btn-success">
            ➕ Ajouter un livre
        </a>
    </div>

    <%-- ==== PIED DE PAGE (copié) ==== --%>
    <footer>
        &copy; 2025 Bibliothèque Communale ‑ Tous droits réservés
    </footer>

</body>
</html>
