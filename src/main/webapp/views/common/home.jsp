<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Usuario" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ImpulsaMe - Crowdfunding</title>
    
    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/messages.css">
</head>
<body>

    <jsp:include page="/views/fragments/header.jspf" />
    <%@ include file="/views/fragments/messages.jspf" %>

    <main>
        <section class="hero-section">
            <%
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                if (usuario != null && usuario.getTelefono() == null) { // ADMIN
            %>
                <h1>Bienvenido a la página de administración</h1>
                <p>Aquí puedes gestionar los proyectos pendientes, revisar mensajes de usuarios y supervisar la actividad de la plataforma.</p>
                <div class="hero-buttons">
                    <a href="${pageContext.request.contextPath}/pendingProjects" class="btn btn-primary">Gestionar Proyectos</a>
                    <a href="${pageContext.request.contextPath}/showMessages" class="btn btn-secondary">Ver Mensajes</a>
                </div>
            <%
                } else {
            %>
                <h1>Financia Tus Sueños</h1>
                <p>Bienvenido a nuestra plataforma de crowdfunding. Aquí puedes encontrar proyectos innovadores para apoyar o puedes crear tu propio proyecto y buscar el financiamiento que necesitas para hacerlo realidad.</p>
                <div class="hero-buttons">
                    <a href="${pageContext.request.contextPath}/activeProjects" class="btn btn-primary">Explorar Proyectos</a>
                    <%
                        if (usuario == null) {
                    %>
                        <a href="${pageContext.request.contextPath}/login" class="btn btn-secondary">Crear Proyecto</a>
                    <%
                        } else {
                    %>
                        <a href="${pageContext.request.contextPath}/createProject" class="btn btn-secondary">Crear Proyecto</a>
                    <%
                        }
                    %>
                </div>
            <%
                }
            %>
        </section>
    </main>

    <jsp:include page="/views/fragments/footer.jspf" />

</body>
</html>
