<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Crowdfunding</title>
    <link rel="icon" href="./assets/simbolo-dinero.png">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link href="style/home.css" rel="stylesheet">
</head>
<body>
    <div class="container mx-auto px-4 py-8">
        <h1 class="text-3xl font-bold text-center mb-4">¡Bienvenido, <c:out value="${usuario.nombre}"/>!</h1>
        <h2 class="text-2xl font-bold text-center mb-8">Lista de Usuarios</h2>

        <c:if test="${not empty error}">
            <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative mb-4" role="alert">
                <span class="block sm:inline">${error}</span>
            </div>
        </c:if>

        <c:if test="${empty usuarios and empty error}">
            <div class="bg-blue-100 border border-blue-400 text-blue-700 px-4 py-3 rounded relative mb-4" role="alert">
                <span class="block sm:inline">No hay usuarios para mostrar.</span>
            </div>
        </c:if>

        <c:if test="${not empty usuarios}">
            <div class="overflow-x-auto">
                <table class="min-w-full bg-white rounded-lg shadow-md">
                    <thead class="bg-gray-200">
                        <tr>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Email</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Nombre</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Apellido</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Teléfono</th>
                        </tr>
                    </thead>
                    <tbody class="divide-y divide-gray-200">
                        <c:forEach var="u" items="${usuarios}">
                            <tr class="hover:bg-gray-100">
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><c:out value="${u.idUsuario}"/></td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><c:out value="${u.email}"/></td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><c:out value="${u.nombre}"/></td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><c:out value="${u.apellido}"/></td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><c:out value="${u.telefono}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
        <div class="flex justify-center mt-8">
            <a href="logout" class="bg-indigo-600 hover:bg-indigo-700 text-white font-bold py-2 px-4 rounded-lg shadow-lg transition duration-300 ease-in-out transform hover:-translate-y-1">
                Salir
            </a>
        </div>
    </div>
</body>
</html>