package interfaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Donacion;

public interface IDonacionDAO {
    List<Donacion> obtenerTodas() throws SQLException;
    Donacion obtenerPorId(int id) throws SQLException;
    void guardar(Donacion donacion) throws SQLException;
}
