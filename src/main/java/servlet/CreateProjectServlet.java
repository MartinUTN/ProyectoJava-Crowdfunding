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

import modelo.Categoria;
import modelo.Pais;
import modelo.Proyecto;
import modelo.Usuario;
import repositorio.CategoriaDAO;
import repositorio.PaisDAO;
import repositorio.ProyectoDAO;

@WebServlet(name = "CreateProjectServlet", urlPatterns = {"/createProject"})
public class CreateProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        PaisDAO paisDAO = new PaisDAO();

        request.setAttribute("categorias", categoriaDAO.obtenerTodos());
        request.setAttribute("paises", paisDAO.obtenerTodos());

        request.getRequestDispatcher("/views/project/create-project.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
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

            Proyecto nuevoProyecto = new Proyecto();
            nuevoProyecto.setNombreProyecto(nombre);
            nuevoProyecto.setDescripcion(descripcion);
            nuevoProyecto.setMontoMeta(montoObjetivo);
            nuevoProyecto.setMontoRecaudado(BigDecimal.ZERO);
            nuevoProyecto.setFechaIni(LocalDate.now());
            nuevoProyecto.setFechaFin(fechaLimite);
            nuevoProyecto.setIdCreador(usuario.getIdUsuario());
            nuevoProyecto.setEstado("Pendiente"); 
            nuevoProyecto.setFoto("default.jpg");

            Categoria categoria = new Categoria();
            categoria.setIdCategoria(idCategoria);
            nuevoProyecto.setCategoria(categoria);

            Pais pais = new Pais();
            pais.setIdPais(idPais);
            nuevoProyecto.setPais(pais);

            ProyectoDAO proyectoDAO = new ProyectoDAO();
            proyectoDAO.insertar(nuevoProyecto);

            request.setAttribute("successMessage", "Proyecto creado correctamente y pendiente de aprobación.");
            response.sendRedirect(request.getContextPath() + "/myProjects");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Hubo un error al crear el proyecto.");
            request.getRequestDispatcher("/views/project/create-project.jsp").forward(request, response);
        }
    }
}
