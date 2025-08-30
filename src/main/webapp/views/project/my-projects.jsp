<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mis Proyectos</title>
    
    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/project/styles/project.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
</head>
<body>
    <jsp:include page="/views/fragments/header.jspf"/>

    <main class="projects-container">
        <h1>Mis Proyectos</h1>

        <c:if test="${empty myProjects}">
            <p class="no-projects">Aún no has creado proyectos.</p>
        </c:if>

        <div class="card-grid">
            <c:forEach var="p" items="${myProjects}">
			    <c:if test="${p.estado ne 'Borrado'}">
			        <div class="project-card">
			            <h2>${p.nombreProyecto}</h2>
			            <p><b>Descripción:</b> ${p.descripcion}</p>
			            <p><b>Monto Meta:</b> $${p.montoMeta}</p>
			            <p><b>Monto Recaudado:</b> $${p.montoRecaudado}</p>
			            <p><b>Fecha Fin:</b> ${p.fechaFin}</p>
			            <p><b>Estado:</b> ${p.estado}</p>
			
			            <p><b>Categoría:</b> ${p.categoria.nombreCategoria}</p>
			            <p><b>País:</b> ${p.pais.nombrePais}</p>
			
			            <c:if test="${p.estado eq 'Cancelado'}">
			                <p><b>Motivo Cancelación:</b> ${p.cancelacion.motivo}</p>
			                <p><b>Fecha Cancelación:</b> ${p.cancelacion.fecha}</p>
			                <form action="${pageContext.request.contextPath}/deleteProject" method="post">
			                    <input type="hidden" name="idProyecto" value="${p.idProyecto}">
			                    <button type="submit" class="btn-danger">Borrar Definitivamente</button>
			                </form>
			            </c:if>
			
			            <c:if test="${p.estado ne 'Cancelado'}">
			                <div class="card-actions">
			                    <form action="${pageContext.request.contextPath}/editProject" method="get" style="display:inline;">
			                        <input type="hidden" name="idProyecto" value="${p.idProyecto}">
			                        <button type="submit" class="btn-view">Editar</button>
			                    </form>
			
			                    <form action="${pageContext.request.contextPath}/cancelProject" method="get" style="display:inline;">
			                        <input type="hidden" name="idProyecto" value="${p.idProyecto}">
			                        <button type="submit" class="btn-reject">Cancelar</button>
			                    </form>
			                </div>
			            </c:if>
			        </div>
			    </c:if>
			</c:forEach>
        </div>
    </main>

    <jsp:include page="/views/fragments/footer.jspf"/>
</body>
</html>
