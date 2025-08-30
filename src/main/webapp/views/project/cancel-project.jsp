<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Cancelar Proyecto</title>

    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/project/styles/project-form.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
</head>
<body>
<jsp:include page="/views/fragments/header.jspf" />

<main class="main-container">
    <div class="form-card">
        <h2>Cancelar Proyecto</h2>

        <form action="${pageContext.request.contextPath}/cancelProject" method="post">
            <input type="hidden" name="idProyecto" value="${idProyecto}">

            <div class="form-group">
                <label for="motivo">Motivo de Cancelación</label>
                <textarea id="motivo" name="motivo" rows="5" placeholder="Explica por qué deseas cancelar este proyecto..." required></textarea>
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-danger">Confirmar Cancelación</button>
                <a href="${pageContext.request.contextPath}/myProjects" class="btn btn-primary">Volver</a>
            </div>
        </form>
    </div>
</main>

<jsp:include page="/views/fragments/footer.jspf" />
</body>
</html>
