package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import modelo.Usuario;
import repositorio.ProyectoDAO;

@WebServlet("/myProjects")
public class MyProjectsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        ProyectoDAO dao = new ProyectoDAO();
        request.setAttribute("myProjects", dao.obtenerPorUsuario(usuario.getIdUsuario()));
        request.getRequestDispatcher("/views/project/my-projects.jsp").forward(request, response);
    }
}
