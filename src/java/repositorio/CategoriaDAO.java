package repositorio;
import interfaces.ICategoriaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.Conexion;
import modelo.Categoria;

public class CategoriaDAO implements ICategoriaDAO {

    @Override
    public List<Categoria> obtenerTodas() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                categorias.add(new Categoria(
                    rs.getInt("idCategoria"),
                    rs.getString("nombre")
                ));
            }
        }
        return categorias;
    }

    @Override
    public Categoria obtenerPorId(int id) throws SQLException {
        Categoria categoria = null;
        String sql = "SELECT * FROM categoria WHERE idCategoria = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria(
                        rs.getInt("idCategoria"),
                        rs.getString("nombre")
                    );
                }
            }
        }
        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (nombre) VALUES (?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
        }
    }
}
