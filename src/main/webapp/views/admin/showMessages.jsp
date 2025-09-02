<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="/views/fragments/header.jspf" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mensajes recibidos</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/globals.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/common/styles/little-glow-buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/styles/showMessages.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/fragments/styles/footer.css">
</head>
<body>
    <main class="messages-container">
        <h1>Mensajes recibidos</h1>

        <c:choose>
            <c:when test="${empty mensajes}">
             	<div class="no-messages-container">
                	<p class="no-messages">No hay mensajes por el momento.</p>
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach var="m" items="${mensajes}">
                    <div class="message-card">
                        <h3>${m.asunto}</h3>
                        <p><strong>De:</strong> ${m.nombre} (${m.email})</p>
                        <p><strong>Fecha:</strong> ${m.fecha}</p>
                        <p><strong>Mensaje:</strong> ${m.mensaje}</p>

                        <div class="message-actions">
                            <form method="post" action="${pageContext.request.contextPath}/showMessages">
                                <input type="hidden" name="id" value="${m.idContacto}">
                                <input type="hidden" name="action" value="revisar">
                                <button type="submit" class="btn btn-review">Revisar</button>
                            </form>
                            <form method="post" action="${pageContext.request.contextPath}/showMessages">
                                <input type="hidden" name="id" value="${m.idContacto}">
                                <input type="hidden" name="action" value="visto">
                                <button type="submit" class="btn btn-seen">✔ Marcar como visto</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </main>

    <%@ include file="/views/fragments/footer.jspf" %>
</body>
</html>
