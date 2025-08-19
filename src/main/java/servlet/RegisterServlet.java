package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/Register", "/register"})
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telefono = request.getParameter("telefono");
        String fechaNacimiento = request.getParameter("fechaNacimiento");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Usuario (email, password, nombre, apellido, telefono, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, email);
            ps.setString(2, password); // ⚠️ en práctica deberías encriptar
            ps.setString(3, nombre);
            ps.setString(4, apellido);
            ps.setString(5, telefono);
            ps.setString(6, fechaNacimiento);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                // Obtener el id generado
                ResultSet rs = ps.getGeneratedKeys();
                int idUsuario = -1;
                if (rs.next()) {
                    idUsuario = rs.getInt(1);
                }

                // Crear sesión automáticamente
                HttpSession session = request.getSession();
                session.setAttribute("idUsuario", idUsuario);
                session.setAttribute("email", email);
                session.setAttribute("nombre", nombre);
                session.setAttribute("apellido", apellido);

                // Redirigir a página de inicio
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("register.jsp?error=1");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=2");
        }
    }
}
