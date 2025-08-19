<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro</title>
</head>
<body>
    <h2>Registro de Usuario</h2>
    <form action="Register" method="post">
        <label>Nombre:</label>
        <input type="text" name="nombre" required /><br>

        <label>Apellido:</label>
        <input type="text" name="apellido" required /><br>

        <label>Email:</label>
        <input type="email" name="email" required /><br>

        <label>Contraseña:</label>
        <input type="password" name="password" required /><br>

        <label>Teléfono:</label>
        <input type="text" name="telefono" /><br>

        <label>Fecha de Nacimiento:</label>
        <input type="date" name="fechaNacimiento" /><br>

        <button type="submit">Registrarme</button>
    </form>
</body>
</html>
