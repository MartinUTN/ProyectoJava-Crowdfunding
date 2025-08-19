package repositorio;
import interfaces.IAvance_ProyectoDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.Conexion;
import modelo.Avance_Proyecto;

public class Avance_ProyectoDAO implements IAvance_ProyectoDAO {

    @Override
    public List<Avance_Proyecto> obtenerPorProyecto(int idProyecto) throws SQLException {
        List<Avance_Proyecto> avances = new ArrayList<>();
        String sql = "SELECT * FROM avance_proyecto WHERE idProyecto = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProyecto);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    avances.add(new Avance_Proyecto(
                        rs.getInt("idAvance"),
                        rs.getInt("idProyecto"),
                        rs.getString("descripcion"),
                        rs.getString("foto"),
                        rs.getDate("fecha")
                    ));
                }
            }
        }
        return avances;
    }

    @Override
    public void guardar(Avance_Proyecto avance) throws SQLException {
        String sql = "INSERT INTO avance_proyecto (idProyecto, descripcion, foto, fecha) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, avance.getIdProyecto());
            ps.setString(2, avance.getDescripcion());
            ps.setString(3, avance.getFoto());
            ps.setDate(4, new java.sql.Date(avance.getFecha().getTime()));
            ps.executeUpdate();
        }
    }
}
