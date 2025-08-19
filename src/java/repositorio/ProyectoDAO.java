package repositorio;
import interfaces.IProyectoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.Conexion;
import modelo.Proyecto;

public class ProyectoDAO implements IProyectoDAO {

    @Override
    public List<Proyecto> obtenerTodos() throws SQLException {
        List<Proyecto> proyectos = new ArrayList<>();
        String sql = "SELECT * FROM proyecto";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                proyectos.add(new Proyecto(
                    rs.getInt("idProyecto"),
                    rs.getInt("idUsuario"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getDouble("montoMeta"),
                    rs.getDouble("montoActual"),
                    rs.getDate("fechaInicio"),
                    rs.getDate("fechaFin"),
                    rs.getInt("idCategoria")
                ));
            }
        }
        return proyectos;
    }

    @Override
    public Proyecto obtenerPorId(int id) throws SQLException {
        Proyecto proyecto = null;
        String sql = "SELECT * FROM proyecto WHERE idProyecto = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    proyecto = new Proyecto(
                        rs.getInt("idProyecto"),
                        rs.getInt("idUsuario"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getDouble("montoMeta"),
                        rs.getDouble("montoActual"),
                        rs.getDate("fechaInicio"),
                        rs.getDate("fechaFin"),
                        rs.getInt("idCategoria")
                    );
                }
            }
        }
        return proyecto;
    }

    @Override
    public void guardar(Proyecto proyecto) throws SQLException {
        String sql = "INSERT INTO proyecto (idUsuario, titulo, descripcion, montoMeta, montoActual, fechaInicio, fechaFin, idCategoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, proyecto.getIdUsuario());
            ps.setString(2, proyecto.getTitulo());
            ps.setString(3, proyecto.getDescripcion());
            ps.setDouble(4, proyecto.getMontoMeta());
            ps.setDouble(5, proyecto.getMontoActual());
            ps.setDate(6, new java.sql.Date(proyecto.getFechaInicio().getTime()));
            ps.setDate(7, new java.sql.Date(proyecto.getFechaFin().getTime()));
            ps.setInt(8, proyecto.getIdCategoria());
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Proyecto proyecto) throws SQLException {
        String sql = "UPDATE proyecto SET idUsuario = ?, titulo = ?, descripcion = ?, montoMeta = ?, montoActual = ?, fechaInicio = ?, fechaFin = ?, idCategoria = ? WHERE idProyecto = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, proyecto.getIdUsuario());
            ps.setString(2, proyecto.getTitulo());
            ps.setString(3, proyecto.getDescripcion());
            ps.setDouble(4, proyecto.getMontoMeta());
            ps.setDouble(5, proyecto.getMontoActual());
            ps.setDate(6, new java.sql.Date(proyecto.getFechaInicio().getTime()));
            ps.setDate(7, new java.sql.Date(proyecto.getFechaFin().getTime()));
            ps.setInt(8, proyecto.getIdCategoria());
            ps.setInt(9, proyecto.getIdProyecto());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM proyecto WHERE idProyecto = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
