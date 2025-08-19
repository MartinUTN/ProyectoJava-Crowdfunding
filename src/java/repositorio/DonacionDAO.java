package repositorio;
import interfaces.IDonacionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.Conexion;
import modelo.Donacion;

public class DonacionDAO implements IDonacionDAO {

    @Override
    public List<Donacion> obtenerTodas() throws SQLException {
        List<Donacion> donaciones = new ArrayList<>();
        String sql = "SELECT * FROM donacion";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                donaciones.add(new Donacion(
                    rs.getInt("idDonacion"),
                    rs.getInt("idProyecto"),
                    rs.getInt("idUsuario"),
                    rs.getDouble("monto"),
                    rs.getDate("fecha")
                ));
            }
        }
        return donaciones;
    }

    @Override
    public Donacion obtenerPorId(int id) throws SQLException {
        Donacion donacion = null;
        String sql = "SELECT * FROM donacion WHERE idDonacion = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    donacion = new Donacion(
                        rs.getInt("idDonacion"),
                        rs.getInt("idProyecto"),
                        rs.getInt("idUsuario"),
                        rs.getDouble("monto"),
                        rs.getDate("fecha")
                    );
                }
            }
        }
        return donacion;
    }

    @Override
    public void guardar(Donacion donacion) throws SQLException {
        String sql = "INSERT INTO donacion (idProyecto, idUsuario, monto, fecha) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, donacion.getIdProyecto());
            ps.setInt(2, donacion.getIdUsuario());
            ps.setDouble(3, donacion.getMonto());
            ps.setDate(4, new java.sql.Date(donacion.getFecha().getTime()));
            ps.executeUpdate();
        }
    }
}
