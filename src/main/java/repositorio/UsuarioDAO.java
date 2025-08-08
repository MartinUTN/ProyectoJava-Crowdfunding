package repositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import db.Conexion;

public class UsuarioDAO {

    public void crear(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuario(email, contrasenia, nombre, apellido) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getContrasenia());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    usuario.setIdUsuario(rs.getInt(1));
                }
            }
        }
    }

    public Usuario obtenerUno(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("email"),
                    rs.getString("contrasenia"),
                    rs.getString("nombre"),
                    rs.getString("apellido")
                );
            }
        }
        return null;
    }

    public Usuario validarUsuario(String email, String contrasenia) throws SQLException {
        String sql = "SELECT idUsuario, email, contrasenia, nombre, apellido FROM Usuario WHERE email = ? AND contrasenia = ?";
        Usuario usuario = null;

        try (Connection con = db.Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, contrasenia);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("email"),
                        rs.getString("contrasenia"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                    );
                }
            }
        }
        
        return usuario;
    }
    
    public List<Usuario> obtenerTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Connection con = Conexion.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("email"),
                    rs.getString("contrasenia"),
                    rs.getString("nombre"),
                    rs.getString("apellido")
                ));
            }
        }
        return lista;
    }

    public void actualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET email = ?, contrasenia = ?, nombre = ?, apellido = ? WHERE idUsuario = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getContrasenia());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setInt(5, usuario.getIdUsuario());
            ps.executeUpdate();
        }
    }

    public void eliminar(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        }
    }
}
