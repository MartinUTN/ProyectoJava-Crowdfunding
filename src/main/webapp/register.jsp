<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro - Crowdfunding</title>
    
    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Estilos personalizados para el registro -->
    <link href="style/register.css" rel="stylesheet">
</head>
<body>
    <main class="form-container">
        <form action="RegisterServlet" method="post">
            <div class="form-header">
                <img src="assets/crowdfunding-logo.png" alt="Logo" width="72" height="57">
                <h1 class="form-title">Crear una cuenta</h1>
            </div>

            <div class="form-floating">
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required>
                <label for="nombre">Nombre</label>
            </div>
            
            <div class="form-floating">
                <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellido" required>
                <label for="apellido">Apellido</label>
            </div>

            <div class="form-floating">
                <input type="email" class="form-control" id="email" name="email" placeholder="nombre@ejemplo.com" required>
                <label for="email">Correo electrónico</label>
            </div>

            <div class="form-floating">
                <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" required>
                <label for="password">Contraseña</label>
            </div>
            
            <div class="form-floating">
                <input type="tel" class="form-control" id="telefono" name="telefono" placeholder="Teléfono">
                <label for="telefono">Teléfono (Opcional)</label>
            </div>
            
            <div class="form-floating">
                <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento">
                <label for="fechaNacimiento">Fecha de Nacimiento (Opcional)</label>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit">Registrarme</button>
            
            <p class="login-link">
                ¿Ya tienes una cuenta? <a href="login.jsp">Inicia sesión</a>
            </p>

            <!-- Botón para volver a la página de inicio -->
            <div class="text-center mt-3">
                <a href="home.jsp" class="btn btn-secondary">Volver</a>
            </div>
        </form>
    </main>
</body>
</html>
