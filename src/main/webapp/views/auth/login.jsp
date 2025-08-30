<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión - ImpulaMe</title>
    
    <link rel="icon" href="${pageContext.request.contextPath}/assets/simbolo-dinero.png">
    
    
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/auth/styles/login.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">

</head>
<body>
	<jsp:include page="/views/fragments/header.jspf" />

    <main class="main-container">
        <div class="form-container">
            <h2>Iniciar Sesión</h2>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="btn-submit">Ingresar</button>
            </form>
        </div>
    </main>
	<%--  
	creo que queda mejor el inicio y el register sin footer
	por ej kickstarter no lo tiene
	
	<jsp:include page="/views/fragments/footer.jspf" />
	--%>
</body>
</html>
