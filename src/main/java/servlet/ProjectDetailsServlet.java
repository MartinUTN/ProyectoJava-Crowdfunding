package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Proyecto;

import java.io.IOException;
import repositorio.ProyectoDAO;

@WebServlet("/projectDetails")
public class ProjectDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParam = request.getParameter("idProyecto");
        if (idParam == null || idParam.isEmpty()) {
            idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                request.setAttribute("errorMessage", "No se especificó un proyecto.");
                request.getRequestDispatcher("/views/project/active-projects.jsp").forward(request, response);
                return;
            }
        }

        try {
            int id = Integer.parseInt(idParam);
            ProyectoDAO dao = new ProyectoDAO();
            Proyecto proyecto = dao.obtenerPorId(id);

            if (proyecto == null) {
                request.setAttribute("errorMessage", "Proyecto no encontrado.");
                request.getRequestDispatcher("/views/project/active-projects.jsp").forward(request, response);
            } else {
                request.setAttribute("proyecto", proyecto);
                request.getRequestDispatcher("/views/project/project-details.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "ID de proyecto inválido.");
            request.getRequestDispatcher("/views/project/active-projects.jsp").forward(request, response);
        }
    }
}