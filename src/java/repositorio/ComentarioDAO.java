package repositorio;
import interfaces.IComentarioDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.Conexion;
import modelo.Comentario;

public class ComentarioDAO implements IComentarioDAO {

    @Override
    public List<Comentario> obtenerTodosPorProyecto(int idProyecto) throws SQLException {
        List<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM comentario WHERE idProyecto = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProyecto);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    comentarios.add(new Comentario(
                        rs.getInt("idComentario"),
                        rs.getInt("idProyecto"),
                        rs.getInt("idUsuario"),
                        rs.getString("texto"),
                        rs.getDate("fecha")
                    ));
                }
            }
        }
        return comentarios;
    }

    @Override
    public void guardar(Comentario comentario) throws SQLException {
        String sql = "INSERT INTO comentario (idProyecto, idUsuario, texto, fecha) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, comentario.getIdProyecto());
            ps.setInt(2, comentario.getIdUsuario());
            ps.setString(3, comentario.getTexto());
            ps.setDate(4, new java.sql.Date(comentario.getFecha().getTime()));
            ps.executeUpdate();
        }
    }
}
