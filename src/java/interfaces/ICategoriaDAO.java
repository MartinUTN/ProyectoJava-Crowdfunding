package interfaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Categoria;

public interface ICategoriaDAO {
    List<Categoria> obtenerTodas() throws SQLException;
    Categoria obtenerPorId(int id) throws SQLException;
    void guardar(Categoria categoria) throws SQLException;
}
