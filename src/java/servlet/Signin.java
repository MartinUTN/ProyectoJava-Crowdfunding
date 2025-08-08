package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import modelo.Usuario;
import repositorio.UsuarioDAO;


@WebServlet({ "/SIGNIN", "/Signin", "/signin", "/SignIn" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		String email = request.getParameter("email");
		String contrasenia = request.getParameter("password");

		Usuario usuario = null;

		try {
			usuario = usuarioDAO.validarUsuario(email, contrasenia);

			if (usuario != null) {
				request.getSession().setAttribute("usuario", usuario);

				List<Usuario> listaUsuarios = usuarioDAO.obtenerTodos();
				request.setAttribute("usuarios", listaUsuarios);

				request.getRequestDispatcher("home.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Email o contraseña incorrectos.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// **CÓDIGO DE DEPURACIÓN AGREGADO**
			e.printStackTrace();
			// Pasamos el mensaje de error exacto de la base de datos al JSP
			request.setAttribute("error", "Error de conexión a la base de datos: " + e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
