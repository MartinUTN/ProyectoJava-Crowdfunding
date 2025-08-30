package repositorio;

import db.Conexion;
import interfaces.IProyectoDAO;
import modelo.Cancelacion_Proyecto;
import modelo.Categoria;
import modelo.Pais;
import modelo.Proyecto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO implements IProyectoDAO {

    private Proyecto mapResultSetToProyecto(ResultSet rs) throws SQLException {
        Proyecto proyecto = new Proyecto();
        proyecto.setIdProyecto(rs.getInt("idProyecto"));
        proyecto.setNombreProyecto(rs.getString("nombreProyecto"));
        proyecto.setDescripcion(rs.getString("descripcion"));
        proyecto.setMontoMeta(rs.getBigDecimal("montoMeta"));
        proyecto.setMontoRecaudado(rs.getBigDecimal("montoRecaudado"));
        proyecto.setFechaIni(rs.getDate("fechaIni").toLocalDate());
        proyecto.setFechaFin(rs.getDate("fechaFin").toLocalDate());
        proyecto.setIdCreador(rs.getInt("idCreador"));
        proyecto.setEstado(rs.getString("estado"));
        proyecto.setFoto(rs.getString("foto"));

        Categoria c = new Categoria();
        c.setIdCategoria(rs.getInt("idCategoria"));
        c.setNombreCategoria(rs.getString("nombreCategoria"));
        proyecto.setCategoria(c);

        Pais p = new Pais();
        p.setIdPais(rs.getInt("idPais"));
        p.setNombrePais(rs.getString("nombrePais"));
        proyecto.setPais(p);

        return proyecto;
    }

    @Override
    public void insertar(Proyecto proyecto) {
        String sql = "INSERT INTO proyecto (nombreProyecto, descripcion, montoMeta, montoRecaudado, fechaIni, fechaFin, idCreador, idCategoria, idPais, estado, foto) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, proyecto.getNombreProyecto());
            ps.setString(2, proyecto.getDescripcion());
            ps.setBigDecimal(3, proyecto.getMontoMeta());
            ps.setBigDecimal(4, proyecto.getMontoRecaudado());
            ps.setDate(5, Date.valueOf(proyecto.getFechaIni()));
            ps.setDate(6, Date.valueOf(proyecto.getFechaFin()));
            ps.setInt(7, proyecto.getIdCreador());
            ps.setInt(8, proyecto.getCategoria().getIdCategoria());
            ps.setInt(9, proyecto.getPais().getIdPais());
            ps.setString(10, proyecto.getEstado());
            ps.setString(11, proyecto.getFoto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Proyecto proyecto) {
        String sql = "UPDATE proyecto SET nombreProyecto = ?, descripcion = ?, montoMeta = ?, fechaFin = ? WHERE idProyecto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, proyecto.getNombreProyecto());
            ps.setString(2, proyecto.getDescripcion());
            ps.setBigDecimal(3, proyecto.getMontoMeta());
            ps.setDate(4, java.sql.Date.valueOf(proyecto.getFechaFin()));
            ps.setInt(5, proyecto.getIdProyecto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        borrarDefinitivamente(id);
    }

    public Proyecto obtenerPorId(int id) {
        Proyecto proyecto = null;
        String sql = "SELECT p.*, c.nombreCategoria, pa.nombrePais " +
                     "FROM proyecto p " +
                     "JOIN categoria c ON p.idCategoria = c.idCategoria " +
                     "JOIN pais pa ON p.idPais = pa.idPais " +
                     "WHERE p.idProyecto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    proyecto = mapResultSetToProyecto(rs);

                    if ("Cancelado".equalsIgnoreCase(proyecto.getEstado())) {
                        Cancelacion_Proyecto c = obtenerCancelacionPorProyecto(id);
                        proyecto.setCancelacion(c);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proyecto;
    }
    
    public void actualizarEstado(int idProyecto, String nuevoEstado) {
        String sql = "UPDATE proyecto SET estado = ? WHERE idProyecto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado);
            ps.setInt(2, idProyecto);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Cancelacion_Proyecto obtenerCancelacionPorProyecto(int idProyecto) {
        String sql = "SELECT * FROM cancelacion_proyecto WHERE idProyecto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProyecto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cancelacion_Proyecto c = new Cancelacion_Proyecto();
                    c.setIdProyecto(rs.getInt("idProyecto"));
                    c.setMotivo(rs.getString("motivo"));
                    c.setFecha(rs.getDate("fecha").toLocalDate());
                    return c;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Proyecto> obtenerActivos() {
        List<Proyecto> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.nombreCategoria, pa.nombrePais " +
                "FROM proyecto p " +
                "JOIN categoria c ON p.idCategoria = c.idCategoria " +
                "JOIN pais pa ON p.idPais = pa.idPais " +
                "WHERE p.estado='Activo'";
        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapResultSetToProyecto(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Proyecto> obtenerPendientes() {
        List<Proyecto> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.nombreCategoria, pa.nombrePais " +
                "FROM proyecto p " +
                "JOIN categoria c ON p.idCategoria = c.idCategoria " +
                "JOIN pais pa ON p.idPais = pa.idPais " +
                "WHERE p.estado='Pendiente'";
        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapResultSetToProyecto(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Proyecto> obtenerPorUsuario(int idUsuario) {
        List<Proyecto> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.nombreCategoria, pa.nombrePais " +
                "FROM proyecto p " +
                "JOIN categoria c ON p.idCategoria = c.idCategoria " +
                "JOIN pais pa ON p.idPais = pa.idPais " +
                "WHERE p.idCreador=? AND p.estado <> 'Borrado'";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Proyecto proyecto = mapResultSetToProyecto(rs);
                    if ("Cancelado".equalsIgnoreCase(proyecto.getEstado())) {
                        Cancelacion_Proyecto c = obtenerCancelacionPorProyecto(proyecto.getIdProyecto());
                        proyecto.setCancelacion(c);
                    }
                    lista.add(proyecto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void cancelarProyecto(Proyecto proyecto, Cancelacion_Proyecto cancelacion) {
        String updateProyecto = "UPDATE proyecto SET estado = ? WHERE idProyecto = ?";
        String insertCancelacion = "INSERT INTO cancelacion_proyecto (idProyecto, motivo, fecha) VALUES (?, ?, ?)";
        try (Connection con = Conexion.getConexion()) {
            try (PreparedStatement ps = con.prepareStatement(updateProyecto)) {
                ps.setString(1, proyecto.getEstado());
                ps.setInt(2, proyecto.getIdProyecto());
                ps.executeUpdate();
            }
            try (PreparedStatement ps = con.prepareStatement(insertCancelacion)) {
                ps.setInt(1, cancelacion.getIdProyecto());
                ps.setString(2, cancelacion.getMotivo());
                ps.setDate(3, java.sql.Date.valueOf(cancelacion.getFecha()));
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarDefinitivamente(int idProyecto) {
        String sql = "UPDATE proyecto SET estado = 'Borrado' WHERE idProyecto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProyecto);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
