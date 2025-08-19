package interfaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Proyecto;

public interface IProyectoDAO {
    List<Proyecto> obtenerTodos() throws SQLException;
    Proyecto obtenerPorId(int id) throws SQLException;
    void guardar(Proyecto proyecto) throws SQLException;
    void actualizar(Proyecto proyecto) throws SQLException;
    void eliminar(int id) throws SQLException;
}
