package repositorio;

// 1. Se importa la interfaz desde el nuevo paquete 'interfaces'
import interfaces.IUsuarioDAO;
import modelo.Usuario;
import db.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// 2. La clase sigue implementando la interfaz como antes
public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public List<Usuario> obtenerTodos() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getDate("fechaNacimiento")
                ));
            }
        }
        return usuarios;
    }

    @Override
    public Usuario obtenerPorId(int id) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getDate("fechaNacimiento")
                    );
                }
            }
        }
        return usuario;
    }
    
    @Override
    public Usuario obtenerPorEmail(String email) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE email = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getDate("fechaNacimiento")
                    );
                }
            }
        }
        return usuario;
    }

    @Override
    public void guardar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (email, password, nombre, apellido, telefono, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setString(5, usuario.getTelefono());
            ps.setDate(6, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET email = ?, password = ?, nombre = ?, apellido = ?, telefono = ?, fechaNacimiento = ? WHERE idUsuario = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setString(5, usuario.getTelefono());
            ps.setDate(6, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            ps.setInt(7, usuario.getIdUsuario());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
