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
        <h1>Bibliothèque Communale</h1>
        <p>Explorez. Découvrez. Apprenez.</p>
    </header>

    <nav>
        <a href="${pageContext.request.contextPath}/">🏠 Accueil</a>
        <a href="${pageContext.request.contextPath}/livres">📇 Catalogue</a>
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

                <h4>Tags associés</h4>
                <c:choose>
                    <c:when test="${empty livre.tags}">
                        <p class="text-muted fst-italic">Aucun tag associé pour l’instant.</p>
                    </c:when>
                    <c:otherwise>
                        <ul class="list-inline">
                            <c:forEach items="${livre.tags}" var="tag">
                                <li class="list-inline-item badge bg-info text-dark mb-1">
                                    ${tag.nomTag}
                                </li>
                            </c:forEach>
                        </ul>
                    </c:otherwise>
                </c:choose>

                <!-- Formulaire d’ajout de tag -->
                <form class="row g-2 mt-3"
                      action="${pageContext.request.contextPath}/livres/${livre.idLivre}/add-tag"
                      method="post">
                    <div class="col-auto">
                        <input type="number" min="1" name="tagId"
                               class="form-control" placeholder="ID du tag" required>
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary">Ajouter le tag</button>
                    </div>
                </form>

                <a href="${pageContext.request.contextPath}/livres"
                   class="btn btn-link mt-3">← Retour au catalogue</a>
            </div>
        </div>

    </div>

    <footer>
        &copy; 2025 Bibliothèque Communale ‑ Tous droits réservés
    </footer>

</body>
</html>
