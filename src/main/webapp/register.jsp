<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro - ImpulsaMe</title>
    
    <link rel="icon" href="./assets/simbolo-dinero.png">
    
    <!-- Using a CDN for Bootstrap for simplicity -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" xintegrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style/login.css">
</head>
<body class="d-flex align-items-center justify-content-center py-5">
    <main class="form-container">
        <form action="RegisterServlet" method="post">
            <div class="text-center mb-4">
                <!-- Corrected image path -->
                <img class="mb-2" src="assets/crowdfunding-impulsame-logo.png" alt="Logo" width="100" height="80">
                <h1 class="h3 mb-3 fw-normal">Crear una cuenta</h1>
            </div>

            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required>
                <label for="nombre">Nombre</label>
            </div>
            
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellido" required>
                <label for="apellido">Apellido</label>
            </div>

            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="email" name="email" placeholder="nombre@ejemplo.com" required>
                <label for="email">Correo electrónico</label>
            </div>

            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" required>
                <label for="password">Contraseña</label>
            </div>
            
            <div class="form-floating mb-3">
                <input type="tel" class="form-control" id="telefono" name="telefono" placeholder="Teléfono (Opcional)">
                <label for="telefono">Teléfono (Opcional)</label>
            </div>
            
            <div class="form-floating mb-3">
                <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento">
                <label for="fechaNacimiento">Fecha de Nacimiento (Opcional)</label>
            </div>

            <button class="w-100 btn btn-lg btn-primary fw-bold" type="submit">Registrarme</button>
            
            <p class="mt-4 mb-2 text-muted text-center">
                ¿Ya tienes una cuenta? <a href="login.jsp" class="text-decoration-none fw-bold">Inicia sesión</a>
            </p>

            <div class="text-center mt-3">
                <a href="home.html" class="btn btn-secondary btn-sm">Volver a Home</a>
            </div>
        </form>
    </main>
</body>
</html>
