<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="/views/fragments/header.jspf" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle del Proyecto</title>
    
    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/project/styles/project.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
</head>
<body>
<main class="projects-container">
    <c:if test="${empty proyecto}">
        <p>Proyecto no encontrado.</p>
    </c:if>

    <c:if test="${not empty proyecto}">
        <div class="project-card">
            <h1>${proyecto.nombreProyecto}</h1>
            <p><strong>Descripción:</strong> ${proyecto.descripcion}</p>
            <p><strong>Monto Meta:</strong> $${proyecto.montoMeta}</p>
            <p><strong>Monto Recaudado:</strong> $${proyecto.montoRecaudado}</p>
            <p><strong>Fecha Inicio:</strong> ${proyecto.fechaIni}</p>
            <p><strong>Fecha Fin:</strong> ${proyecto.fechaFin}</p>
            <p><strong>Estado:</strong> ${proyecto.estado}</p>
			<p><strong>Categoría:</strong> ${proyecto.categoria.nombreCategoria}</p>
			<p><strong>País:</strong> ${proyecto.pais.nombrePais}</p>

        </div>
    </c:if>
</main>

<jsp:include page="/views/fragments/footer.jspf" />
</body>
</html>
