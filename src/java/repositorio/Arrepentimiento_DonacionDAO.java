package repositorio;
import interfaces.IArrepentimiento_DonacionDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.Conexion;
import modelo.Arrepentimiento_Donacion;

public class Arrepentimiento_DonacionDAO implements IArrepentimiento_DonacionDAO {

    @Override
    public void guardar(Arrepentimiento_Donacion arrepentimiento) throws SQLException {
        String sql = "INSERT INTO arrepentimiento_donacion (idDonacion, motivo, fecha) VALUES (?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, arrepentimiento.getIdDonacion());
            ps.setString(2, arrepentimiento.getMotivo());
            ps.setDate(3, new java.sql.Date(arrepentimiento.getFecha().getTime()));
            ps.executeUpdate();
        }
    }
}
