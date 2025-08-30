package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import modelo.Contacto;
import repositorio.ContactoDAO;

@WebServlet(name = "ShowMessagesServlet", urlPatterns = {"/showMessages"})
public class ShowMessagesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ContactoDAO dao = new ContactoDAO();
        List<Contacto> mensajes = dao.obtenerTodos();

        request.setAttribute("mensajes", mensajes);
        request.getRequestDispatcher("/views/admin/showMessages.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        ContactoDAO dao = new ContactoDAO();

        if ("visto".equals(action)) {
            dao.marcarComoVisto(id);
        } else if ("revisar".equals(action)) {
            response.sendRedirect(request.getContextPath() + "/verMensaje?id=" + id);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/showMessages");
    }
}
