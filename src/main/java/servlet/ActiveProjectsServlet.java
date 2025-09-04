package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import modelo.Proyecto;
import repositorio.ProyectoDAO;

@WebServlet("/activeProjects")
public class ActiveProjectsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProyectoDAO dao = new ProyectoDAO();
        String query = request.getParameter("query");
        List<Proyecto> proyectos;

        if (query != null && !query.trim().isEmpty()) {
            proyectos = dao.buscarProyectos(query);
            request.setAttribute("searchQuery", query);
        } else {
            // Si no hay búsqueda, obtenemos todos los proyectos activos.
            // Necesitamos un método para esto. Asumiremos que buscarProyectos con null o vacío hace eso.
            proyectos = dao.buscarProyectos(null);
        }

        request.setAttribute("activeProjects", proyectos);
        request.getRequestDispatcher("/views/project/active-projects.jsp").forward(request, response);
    }
}

