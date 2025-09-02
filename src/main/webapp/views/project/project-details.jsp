<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle del Proyecto</title>
    
    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/project/styles/project-details.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
</head>
<body>
	<%@ include file="/views/fragments/header.jspf" %>
	<main class="projects-container">
	
	        <div class="project-card">
	            <h1>${proyecto.nombreProyecto}</h1>
	            <img src="${pageContext.request.contextPath}/uploads/${proyecto.foto}" alt="Imagen del Proyecto">
	            <p><strong>Descripción:</strong> ${proyecto.descripcion}</p>
	            <p><strong>Monto Meta:</strong> $${proyecto.montoMeta}</p>
	            <p><strong>Monto Recaudado:</strong> $${proyecto.montoRecaudado}</p>
	            <p><strong>Fecha Inicio:</strong> ${proyecto.fechaIni}</p>
	            <p><strong>Fecha Fin:</strong> ${proyecto.fechaFin}</p>
	            <p><strong>Estado:</strong> ${proyecto.estado}</p>
				<p><strong>Categoría:</strong> ${proyecto.categoria.nombreCategoria}</p>
				<p><strong>País:</strong> ${proyecto.pais.nombrePais}</p>
	        </div>
	</main>
	<jsp:include page="/views/fragments/footer.jspf" />
</body>
</html>
