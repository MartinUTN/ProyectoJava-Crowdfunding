package servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import modelo.Usuario;
import repositorio.UsuarioDAO;

/**
 * Servlet implementation class Signin
 */
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("password");
		
		try {
			Usuario usuario = usuarioDAO.validarUsuario(email, contrasenia);
			
			if (usuario != null) {
				request.getSession().setAttribute("usuario", usuario);
				response.sendRedirect(request.getContextPath() + "/home.jsp");
			} else {
				request.setAttribute("error", "Email o contraseña incorrectos.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "Error en la base de datos.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}


}
