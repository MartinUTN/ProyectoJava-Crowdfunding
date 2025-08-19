package servlet;
import interfaces.IUsuarioDAO;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;
import repositorio.UsuarioDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Se inicializa con la implementación concreta
        this.usuarioDAO = new UsuarioDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Se utiliza la interfaz para buscar al usuario
            Usuario usuario = usuarioDAO.obtenerPorEmail(email);

            if (usuario != null && usuario.getPassword().equals(password)) {
                // Si el usuario y la contraseña son correctos, crear sesión
                HttpSession session = request.getSession();
                session.setAttribute("idUsuario", usuario.getIdUsuario());
                session.setAttribute("email", usuario.getEmail());
                session.setAttribute("nombre", usuario.getNombre());

                response.sendRedirect("home.jsp");
            } else {
                // Si los datos son incorrectos, redirigir al login con error
                request.setAttribute("error", "Email o contraseña incorrectos.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=db");
        }
    }
}
