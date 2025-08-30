package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Proyecto;
import modelo.Usuario;
import repositorio.ProyectoDAO;

@WebServlet(name = "CrearProyectoServlet", urlPatterns = {"/crearProyecto"})
public class CrearProyectoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect(request.getContextPath() + "/views/auth/login.jsp");
            return;
        }

        try {
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            BigDecimal montoObjetivo = new BigDecimal(request.getParameter("monto_objetivo"));
            LocalDate fechaLimite = LocalDate.parse(request.getParameter("fecha_limite"));
            int idCategoria = Integer.parseInt(request.getParameter("categoria"));
            int idPais = Integer.parseInt(request.getParameter("pais"));

            Usuario usuario = (Usuario) session.getAttribute("usuario");
            int idUsuario = usuario.getIdUsuario();

            Proyecto nuevoProyecto = new Proyecto();
            nuevoProyecto.setNombreProyecto(nombre);
            nuevoProyecto.setDescripcion(descripcion);
            nuevoProyecto.setMontoMeta(montoObjetivo);
            nuevoProyecto.setMontoRecaudado(BigDecimal.ZERO);
            nuevoProyecto.setFechaIni(LocalDate.now());
            nuevoProyecto.setFechaFin(fechaLimite);
            nuevoProyecto.setIdCreador(idUsuario);
            nuevoProyecto.setIdCategoria(idCategoria);
            nuevoProyecto.setIdPais(idPais);
            nuevoProyecto.setEstado("Activo");
            nuevoProyecto.setFoto("default.jpg");

            ProyectoDAO proyectoDAO = new ProyectoDAO();
            proyectoDAO.insertar(nuevoProyecto);

            response.sendRedirect(request.getContextPath() + "/views/common/home.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Hubo un error al crear el proyecto.");
            request.getRequestDispatcher("/views/proyecto/crear_proyecto.jsp").forward(request, response);
        }
    }
}
