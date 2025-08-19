package repositorio;
import interfaces.IPaisDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.Conexion;
import modelo.Pais;

public class PaisDAO implements IPaisDAO {

    @Override
    public List<Pais> obtenerTodos() throws SQLException {
        List<Pais> paises = new ArrayList<>();
        String sql = "SELECT * FROM pais";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                paises.add(new Pais(
                    rs.getInt("idPais"),
                    rs.getString("nombre")
                ));
            }
        }
        return paises;
    }

    @Override
    public Pais obtenerPorId(int id) throws SQLException {
        Pais pais = null;
        String sql = "SELECT * FROM pais WHERE idPais = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pais = new Pais(
                        rs.getInt("idPais"),
                        rs.getString("nombre")
                    );
                }
            }
        }
        return pais;
    }
}
