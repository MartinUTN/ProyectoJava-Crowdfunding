package repositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import db.Conexion;

public class UsuarioDAO {

    /**
     * Inserta un nuevo usuario en la base de datos.
     * El idUsuario se genera automáticamente y se asigna al objeto.
     * @param usuario El objeto Usuario a insertar.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public void crear(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuario(email, contrasenia, nombre, apellido, telefono, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getContrasenia());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setString(5, usuario.getTelefono());
            if (usuario.getFechaNacimiento() != null) {
                ps.setDate(6, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            } else {
                ps.setNull(6, Types.DATE);
            }
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    usuario.setIdUsuario(rs.getInt(1));
                }
            }
        }
    }

    /**
     * Obtiene un usuario por su ID.
     * @param idUsuario El ID del usuario a buscar.
     * @return El objeto Usuario si se encuentra, de lo contrario, null.
     * @throws SQLException Si ocurre un error de SQL.
     */
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
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getDate("fechaNacimiento")
                );
            }
        }
        return null;
    }

    /**
     * Valida si un usuario existe con el email y contraseña proporcionados.
     * @param email El email del usuario.
     * @param contrasenia La contraseña del usuario.
     * @return El objeto Usuario si las credenciales son correctas, de lo contrario, null.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public Usuario validarUsuario(String email, String contrasenia) throws SQLException {
        String sql = "SELECT idUsuario, email, contrasenia, nombre, apellido, telefono, fechaNacimiento FROM Usuario WHERE email = ? AND contrasenia = ?";
        Usuario usuario = null;

        try (Connection con = Conexion.obtenerConexion();
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
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getDate("fechaNacimiento")
                    );
                }
            }
        }
        return usuario;
    }
    
    /**
     * Obtiene una lista de todos los usuarios de la base de datos.
     * @return Una lista de objetos Usuario.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public List<Usuario> obtenerTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("email"),
                    rs.getString("contrasenia"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getDate("fechaNacimiento")
                ));
            }
        }
        return lista;
    }

    /**
     * Actualiza los datos de un usuario en la base de datos.
     * @param usuario El objeto Usuario con los datos actualizados.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public void actualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET email = ?, contrasenia = ?, nombre = ?, apellido = ?, telefono = ?, fechaNacimiento = ? WHERE idUsuario = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getContrasenia());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setString(5, usuario.getTelefono());
            if (usuario.getFechaNacimiento() != null) {
                ps.setDate(6, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            } else {
                ps.setNull(6, Types.DATE);
            }
            ps.setInt(7, usuario.getIdUsuario());
            ps.executeUpdate();
        }
    }

    /**
     * Elimina un usuario de la base de datos por su ID.
     * @param idUsuario El ID del usuario a eliminar.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public void eliminar(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        }
    }
}