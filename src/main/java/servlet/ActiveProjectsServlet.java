package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import repositorio.ProyectoDAO;

@WebServlet("/activeProjects")
public class ActiveProjectsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProyectoDAO dao = new ProyectoDAO();
        request.setAttribute("activeProjects", dao.obtenerActivos());
        request.getRequestDispatcher("/views/project/active-projects.jsp").forward(request, response);
    }
}
