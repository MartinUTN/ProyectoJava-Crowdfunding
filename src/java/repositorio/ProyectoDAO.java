package repositorio;

import db.Conexion;
import interfaces.IProyectoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Proyecto;

public class ProyectoDAO implements IProyectoDAO {

    @Override
    public void insertar(Proyecto proyecto) {
        String sql = "INSERT INTO proyecto (nombreProyecto, descripcion, montoMeta, fechaIni, fechaFin, estado, montoRecaudado, idCreador, idCategoria, foto, idPais) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, proyecto.getNombreProyecto());
            ps.setString(2, proyecto.getDescripcion());
            ps.setBigDecimal(3, proyecto.getMontoMeta());
            ps.setDate(4, java.sql.Date.valueOf(proyecto.getFechaIni()));
            ps.setDate(5, java.sql.Date.valueOf(proyecto.getFechaFin()));
            ps.setString(6, proyecto.getEstado());
            ps.setBigDecimal(7, proyecto.getMontoRecaudado());
            ps.setInt(8, proyecto.getIdCreador());
            ps.setInt(9, proyecto.getIdCategoria());
            ps.setString(10, proyecto.getFoto());
            ps.setInt(11, proyecto.getIdPais());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Proyecto> obtenerTodos() {
        List<Proyecto> proyectos = new ArrayList<>();
        String sql = "SELECT * FROM proyecto";
        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Proyecto proyecto = new Proyecto();
                proyecto.setIdProyecto(rs.getInt("idProyecto"));
                proyecto.setNombreProyecto(rs.getString("nombreProyecto"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setMontoMeta(rs.getBigDecimal("montoMeta"));
                proyecto.setFechaIni(rs.getDate("fechaIni").toLocalDate());
                proyecto.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                proyecto.setEstado(rs.getString("estado"));
                proyecto.setMontoRecaudado(rs.getBigDecimal("montoRecaudado"));
                proyecto.setIdCreador(rs.getInt("idCreador"));
                proyecto.setIdCategoria(rs.getInt("idCategoria"));
                proyectos.add(proyecto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proyectos;
    }

    @Override
    public Proyecto obtenerPorId(int id) {
        Proyecto proyecto = null;
        String sql = "SELECT * FROM proyecto WHERE idProyecto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    proyecto = new Proyecto();
                    proyecto.setIdProyecto(rs.getInt("idProyecto"));
                    proyecto.setNombreProyecto(rs.getString("nombreProyecto"));
                    proyecto.setDescripcion(rs.getString("descripcion"));
                    proyecto.setMontoMeta(rs.getBigDecimal("montoMeta"));
                    proyecto.setFechaIni(rs.getDate("fechaIni").toLocalDate());
                    proyecto.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                    proyecto.setEstado(rs.getString("estado"));
                    proyecto.setMontoRecaudado(rs.getBigDecimal("montoRecaudado"));
                    proyecto.setIdCreador(rs.getInt("idCreador"));
                    proyecto.setIdCategoria(rs.getInt("idCategoria"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proyecto;
    }

    @Override
    public void actualizar(Proyecto proyecto) {
        String sql = "UPDATE proyecto SET nombreProyecto = ?, descripcion = ?, montoMeta = ?, fechaIni = ?, fechaFin = ?, estado = ?, montoRecaudado = ?, idCreador = ?, idCategoria = ? WHERE idProyecto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, proyecto.getNombreProyecto());
            ps.setString(2, proyecto.getDescripcion());
            ps.setBigDecimal(3, proyecto.getMontoMeta());
            ps.setDate(4, java.sql.Date.valueOf(proyecto.getFechaIni()));
            ps.setDate(5, java.sql.Date.valueOf(proyecto.getFechaFin()));
            ps.setString(6, proyecto.getEstado());
            ps.setBigDecimal(7, proyecto.getMontoRecaudado());
            ps.setInt(8, proyecto.getIdCreador());
            ps.setInt(9, proyecto.getIdCategoria());
            ps.setInt(10, proyecto.getIdProyecto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM proyecto WHERE idProyecto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
