package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import repositorio.ProyectoDAO;

@WebServlet(name = "DeleteProjectServlet", urlPatterns = {"/deleteProject"})
public class DeleteProjectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));

            ProyectoDAO dao = new ProyectoDAO();
            dao.borrarDefinitivamente(idProyecto);

            response.sendRedirect(request.getContextPath() + "/myProjects");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error al borrar el proyecto.");
            request.getRequestDispatcher("/views/project/my-projects.jsp").forward(request, response);
        }
    }
}
