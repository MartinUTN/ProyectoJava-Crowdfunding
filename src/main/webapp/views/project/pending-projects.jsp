<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Proyectos Pendientes</title>
    
    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/project/styles/project.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/little-glow-buttons.css">

</head>
<body>
    <jsp:include page="/views/fragments/header.jspf"/>

    <main class="projects-container">
        <h1>Proyectos Pendientes</h1>

        <c:if test="${empty pendingProjects}">
            <p class="no-projects">No hay proyectos pendientes por el momento.</p>
        </c:if>

        <div class="card-grid">
            <c:forEach var="p" items="${pendingProjects}">
                <div class="project-card"  onclick="window.location.href='${pageContext.request.contextPath}/projectDetails?id=${p.idProyecto}'">
                    <img src="${pageContext.request.contextPath}/uploads/${p.foto}" alt="Imagen del Proyecto">
                    <div class="project-details-wrapper">
                        <h2>${p.nombreProyecto}</h2>
                        <p><b>Categoría:</b> ${p.categoria.nombreCategoria}</p>
                        <p><b>País:</b> ${p.pais.nombrePais}</p>
                        <p><b>Monto Meta:</b> $${p.montoMeta}</p>
                        <p><b>Recaudado:</b> $${p.montoRecaudado}</p>
                        <br>

                        <div class="card-actions">
                            <form action="${pageContext.request.contextPath}/approveProject" method="post">
                                <input type="hidden" name="idProyecto" value="${p.idProyecto}">
                                <button class="little-glow-btn-inverse" type="submit">Aprobar</button>
                            </form>
                            <br>
                            <form action="${pageContext.request.contextPath}/rejectProject" method="post">
                                <input type="hidden" name="idProyecto" value="${p.idProyecto}">
                                <button class="little-glow-btn" type="submit">Rechazar</button>
                            </form>
                            <br>
    						<form action="${pageContext.request.contextPath}/projectDetails" method="get">
    						    <input type="hidden" name="idProyecto" value="${p.idProyecto}">
    						    <button type="submit" class="little-glow-btn-inverse">Ver más</button>
    						</form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </main>

    <jsp:include page="/views/fragments/footer.jspf"/>
</body>
</html>