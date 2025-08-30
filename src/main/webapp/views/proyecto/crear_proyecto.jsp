<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.Usuario" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Nuevo Proyecto - ImpulaMe</title>
    
    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">
    
    
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/proyecto/styles/crear_proyecto.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
</head>
<body>
	<jsp:include page="/views/fragments/header.jspf" />

    <main class="main-container">
        <div class="form-container">
            <h2>Lanza tu Proyecto</h2>
            <p>Completa los siguientes campos para dar de alta tu campaña de crowdfunding.</p>
            
            <% 
                if (usuario == null) {
                    response.sendRedirect("login.jsp");
                    return;
                }
            %>

            <form action="crearProyecto" method="post" class="form-content">
                <div class="form-group">
                    <label for="nombre">Título del Proyecto</label>
                    <input type="text" id="nombre" name="nombre" required>
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción</label>
                    <textarea id="descripcion" name="descripcion" rows="5" required></textarea>
                </div>
                <div class="form-group">
                    <label for="monto_objetivo">Monto Objetivo ($)</label>
                    <input type="number" id="monto_objetivo" name="monto_objetivo" step="0.01" min="1" required>
                </div>
                <div class="form-group">
                    <label for="fecha_limite">Fecha Límite</label>
                    <input type="date" id="fecha_limite" name="fecha_limite" required>
                </div>
                 <div class="form-group">
                    <label for="categoria">Categoría</label>
                    <select id="categoria" name="categoria" required>
                        <option value="1">Tecnología</option>
                        <option value="2">Arte</option>
                        <option value="3">Música</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="pais">País</label>
                    <select id="pais" name="pais" required>
                        <option value="1">Argentina</option>
                        <option value="4">Chile</option>
                        <option value="5">Colombia</option>
                    </select>
                </div>
                <button type="submit" class="btn-submit">Crear Proyecto</button>
            </form>
        </div>
    </main>

	<jsp:include page="/views/fragments/footer.jspf" />
</body>
</html>
