<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Proyectos Activos</title>
    
    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/project/styles/project.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
</head>
<body>
    <jsp:include page="/views/fragments/header.jspf"/>

    <main class="projects-container">
        <h1>Proyectos Activos</h1>

        <c:if test="${empty activeProjects}">
            <p class="no-projects">No hay proyectos activos en este momento.</p>
        </c:if>

        <div class="card-grid">
            <c:forEach var="p" items="${activeProjects}">
                <div class="project-card" onclick="window.location.href='${pageContext.request.contextPath}/projectDetails?id=${p.idProyecto}'">
                    <h2>${p.nombreProyecto}</h2>
                    <p><b>Descripción:</b> ${p.descripcion}</p>
                    <p><b>Monto Meta:</b> $${p.montoMeta}</p>
                    <p><b>Monto Recaudado:</b> $${p.montoRecaudado}</p>
                    <p><b>Fecha Fin:</b> ${p.fechaFin}</p>
                </div>
            </c:forEach>
        </div>
    </main>

    <jsp:include page="/views/fragments/footer.jspf"/>
</body>
</html>
