package repositorio;
import interfaces.ICancelacion_ProyectoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.Conexion;
import modelo.Cancelacion_Proyecto;

public class Cancelacion_ProyectoDAO implements ICancelacion_ProyectoDAO {

    @Override
    public void guardar(Cancelacion_Proyecto cancelacion) throws SQLException {
        String sql = "INSERT INTO cancelacion_proyecto (idProyecto, motivo, fecha) VALUES (?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cancelacion.getIdProyecto());
            ps.setString(2, cancelacion.getMotivo());
            ps.setDate(3, new java.sql.Date(cancelacion.getFecha().getTime()));
            ps.executeUpdate();
        }
    }
}
