<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="/views/fragments/header.jspf" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Proyecto</title>
    
    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/project/styles/project-form.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
</head>
<body>
    <main class="main-container">
        <div class="form-card">
            <h2>Editar Proyecto</h2>

            <form action="${pageContext.request.contextPath}/editProject" method="post" class="form-content">
                <input type="hidden" name="idProyecto" value="${proyecto.idProyecto}">

                <div class="form-group">
                    <label for="nombre">Título del Proyecto</label>
                    <input type="text" id="nombre" name="nombre" value="${proyecto.nombreProyecto}" required>
                </div>

                <div class="form-group">
                    <label for="descripcion">Descripción</label>
                    <textarea id="descripcion" name="descripcion" rows="5" required>${proyecto.descripcion}</textarea>
                </div>

                <div class="form-group">
                    <label for="montoMeta">Monto Meta ($)</label>
                    <input type="number" id="montoMeta" name="montoMeta" step="0.01" min="1" value="${proyecto.montoMeta}" required>
                </div>

                <div class="form-group">
                    <label for="fechaFin">Fecha Límite</label>
                    <input type="date" id="fechaFin" name="fechaFin" value="${proyecto.fechaFin}" required>
                </div>

                <div class="form-buttons">
                    <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                    <a href="${pageContext.request.contextPath}/myProjects" class="btn btn-danger">Cancelar</a>
                </div>
            </form>
        </div>
    </main>

    <jsp:include page="/views/fragments/footer.jspf" />
</body>
</html>
