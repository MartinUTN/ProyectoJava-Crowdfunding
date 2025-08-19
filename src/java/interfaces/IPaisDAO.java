package interfaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Pais;

public interface IPaisDAO {
    List<Pais> obtenerTodos() throws SQLException;
    Pais obtenerPorId(int id) throws SQLException;
}
