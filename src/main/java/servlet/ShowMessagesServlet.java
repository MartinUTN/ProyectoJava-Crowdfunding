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
        
        // La lógica se ha movido a MessageDetailServlet
        // Este POST ahora simplemente redirige al detalle del mensaje
        String id = request.getParameter("id");
        response.sendRedirect(request.getContextPath() + "/messageDetail?id=" + id);
    }
}
