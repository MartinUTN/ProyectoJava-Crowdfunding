package repositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import db.Conexion;

public class ClienteDAO {

    public void crear(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Usuario(email, contrasenia, nombre, apellido, telefono, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente.getEmail());
            ps.setString(2, cliente.getContrasenia());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getApellido());
            ps.setString(5, cliente.getTelefono());
            ps.setDate(6, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setIdUsuario(rs.getInt(1));
                }
            }
        }
    }

    public Cliente obtenerUno(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Cliente(
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

    public List<Cliente> obtenerTodos() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuario WHERE telefono IS NOT NULL OR fechaNacimiento IS NOT NULL";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Cliente(
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

    public void actualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE Usuario SET email = ?, contrasenia = ?, nombre = ?, apellido = ?, telefono = ?, fechaNacimiento = ? WHERE idUsuario = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getEmail());
            ps.setString(2, cliente.getContrasenia());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getApellido());
            ps.setString(5, cliente.getTelefono());
            ps.setDate(6, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            ps.setInt(7, cliente.getIdUsuario());
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
