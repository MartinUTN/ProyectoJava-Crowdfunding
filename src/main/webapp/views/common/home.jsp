<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

</head>
<body>

	<jsp:include page="/views/fragments/header.jspf" />

    <main>
        <section class="hero-section">
            <h1>Financia Tus Sueños</h1>
            <p>Bienvenido a nuestra plataforma de crowdfunding. Aquí puedes encontrar proyectos innovadores para apoyar o puedes crear tu propio proyecto y buscar el financiamiento que necesitas para hacerlo realidad.</p>
            <div class="hero-buttons">
                <a href="#" class="btn btn-primary">Explorar Proyectos</a>
                <a href="#" class="btn btn-secondary">Crear Proyecto</a>
            </div>
        </section>
    </main>

	<jsp:include page="/views/fragments/footer.jspf" />

</body>
</html>
