package repositorio;

import db.Conexion;
import interfaces.IComentarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Comentario;

public class ComentarioDAO implements IComentarioDAO {

    @Override
    public void insertar(Comentario comentario) {
        String sql = "INSERT INTO comentario (titulo, fecha, descripcion, idProyecto, idUsuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, comentario.getTitulo());
            ps.setDate(2, java.sql.Date.valueOf(comentario.getFecha()));
            ps.setString(3, comentario.getDescripcion());
            ps.setInt(4, comentario.getIdProyecto());
            ps.setInt(5, comentario.getIdUsuario());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comentario> obtenerTodos() {
        List<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM comentario";
        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Comentario comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("idComentario"));
                comentario.setTitulo(rs.getString("titulo"));
                comentario.setFecha(rs.getDate("fecha").toLocalDate());
                comentario.setDescripcion(rs.getString("descripcion"));
                comentario.setIdProyecto(rs.getInt("idProyecto"));
                comentario.setIdUsuario(rs.getInt("idUsuario"));
                comentarios.add(comentario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comentarios;
    }

    @Override
    public Comentario obtenerPorId(int id) {
        Comentario comentario = null;
        String sql = "SELECT * FROM comentario WHERE idComentario = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    comentario = new Comentario();
                    comentario.setIdComentario(rs.getInt("idComentario"));
                    comentario.setTitulo(rs.getString("titulo"));
                    comentario.setFecha(rs.getDate("fecha").toLocalDate());
                    comentario.setDescripcion(rs.getString("descripcion"));
                    comentario.setIdProyecto(rs.getInt("idProyecto"));
                    comentario.setIdUsuario(rs.getInt("idUsuario"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comentario;
    }

    @Override
    public void actualizar(Comentario comentario) {
        String sql = "UPDATE comentario SET titulo = ?, fecha = ?, descripcion = ?, idProyecto = ?, idUsuario = ? WHERE idComentario = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, comentario.getTitulo());
            ps.setDate(2, java.sql.Date.valueOf(comentario.getFecha()));
            ps.setString(3, comentario.getDescripcion());
            ps.setInt(4, comentario.getIdProyecto());
            ps.setInt(5, comentario.getIdUsuario());
            ps.setInt(6, comentario.getIdComentario());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM comentario WHERE idComentario = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
