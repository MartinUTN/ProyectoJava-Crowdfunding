package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;
// Importa la interfaz desde su nuevo paquete
import interfaces.IUsuarioDAO; 
import repositorio.UsuarioDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        this.usuarioDAO = new UsuarioDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telefono = request.getParameter("telefono");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        
        Date fechaNacimiento = null;
        try {
            if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
                fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Se crea un objeto Usuario (sin el ID, ya que es autoincremental)
        Usuario nuevoUsuario = new Usuario(0, email, password, nombre, apellido, telefono, fechaNacimiento);

        try {
            usuarioDAO.guardar(nuevoUsuario);
            
            // Opcional: Iniciar sesión automáticamente después del registro
            Usuario usuarioRegistrado = usuarioDAO.obtenerPorEmail(email);
            if (usuarioRegistrado != null) {
                HttpSession session = request.getSession();
                session.setAttribute("idUsuario", usuarioRegistrado.getIdUsuario());
                session.setAttribute("email", usuarioRegistrado.getEmail());
                session.setAttribute("nombre", usuarioRegistrado.getNombre());
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=db");
        }
    }
}
