<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión - Crowdfunding</title>
    
    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Estilos personalizados (puedes usar los mismos de register.css o crear un login.css) -->
    <link href="style/register.css" rel="stylesheet">
</head>
<body>
    <main class="form-container">
        <form action="LoginServlet" method="post">
            <div class="form-header">
                <img src="assets/crowdfunding-logo.png" alt="Logo" width="72" height="57">
                <h1 class="form-title">Iniciar Sesión</h1>
            </div>

            <div class="form-floating">
                <input type="email" class="form-control" id="email" name="email" placeholder="nombre@ejemplo.com" required>
                <label for="email">Correo electrónico</label>
            </div>

            <div class="form-floating">
                <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" required>
                <label for="password">Contraseña</label>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit">Ingresar</button>
            
            <p class="login-link">
                ¿No tienes una cuenta? <a href="register.jsp">Regístrate</a>
            </p>
            
            <!-- Botón para volver a la página de inicio -->
            <div class="text-center mt-3">
                <a href="home.jsp" class="btn btn-secondary">Volver</a>
            </div>
        </form>
    </main>
</body>
</html>
