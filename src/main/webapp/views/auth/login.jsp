<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión - ImpulsaMe</title>

    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/auth/styles/form.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/little-glow-buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
</head>
<body>
    <jsp:include page="/views/fragments/header.jspf" />

    <main class="main-container">
        <div class="form-card">
            <h2>Iniciar Sesión</h2>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <input type="email" id="email" name="email" placeholder=" " required>
                    <label for="email">Correo electrónico</label>
                </div>
                <div class="form-group">
                    <input type="password" id="password" name="password" placeholder=" " required>
                    <label for="password">Contraseña</label>
                </div>
                <button type="submit" class="glow-btn">Ingresar</button>
            </form>
        </div>
    </main>

    <jsp:include page="/views/fragments/footer.jspf" />
</body>
</html>
