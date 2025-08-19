<%@page import="java.util.List"%>
<%@page import="modelo.Usuario"%>
<%@page import="repositorio.UsuarioDAO"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Crowdfunding</title>
    <link href="style/bootstrap.css" rel="stylesheet">
    <link href="style/signin.css" rel="stylesheet">
    <link href="style/home.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="header">
            <% 
                // Obtiene el usuario de la sesión para el mensaje de bienvenida
                Usuario usuarioLogueado = (Usuario) request.getSession().getAttribute("usuario");
                if (usuarioLogueado != null) {
            %>
                <h1 class="h3 mb-3 font-weight-normal">¡Bienvenido, <%= usuarioLogueado.getNombre() %>!</h1>
            <%
                }
            %>
            <h2 class="h3 mb-3 font-weight-normal">Lista de Usuarios</h2>
        </div>

        <% 
            List<Usuario> listaUsuarios = null;
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            try {
                // Llama al método del DAO para obtener todos los usuarios de la base de datos
                listaUsuarios = usuarioDAO.obtenerTodos();
            } catch (SQLException e) {
                // Manejo de errores de la base de datos
                out.println("<div class='alert alert-danger'>Error al obtener la lista de usuarios.</div>");
                e.printStackTrace();
            }
        %>
        
        <% if (listaUsuarios != null && !listaUsuarios.isEmpty()) { %>
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Email</th>
                        <th scope="col">Tipo</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        // Itera sobre la lista de usuarios para mostrar los datos en la tabla
                        for (Usuario u : listaUsuarios) { 
                            String tipoUsuario = "Usuario";
                            // Lógica simple para determinar el tipo de usuario basada en las columnas de la tabla Usuario
                            if ("admin@crowdfunding.com".equalsIgnoreCase(u.getEmail())) {
                                tipoUsuario = "Administrador";
                            } else if (u.getTelefono() != null || u.getFechaNacimiento() != null) {
                                tipoUsuario = "Cliente";
                            }
                    %>
                        <tr>
                            <td><%= u.getIdUsuario() %></td>
                            <td><%= u.getNombre() %></td>
                            <td><%= u.getApellido() %></td>
                            <td><%= u.getEmail() %></td>
                            <td><%= tipoUsuario %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } else { %>
            <div class="alert alert-info" role="alert">
                No hay usuarios para mostrar.
            </div>
        <% } %>
    </div>
</body>
</html>
