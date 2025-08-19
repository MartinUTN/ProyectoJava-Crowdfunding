package interfaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Usuario;

public interface IUsuarioDAO {
    List<Usuario> obtenerTodos() throws SQLException;
    Usuario obtenerPorId(int id) throws SQLException;
    Usuario obtenerPorEmail(String email) throws SQLException;
    void guardar(Usuario usuario) throws SQLException;
    void actualizar(Usuario usuario) throws SQLException;
    void eliminar(int id) throws SQLException;
}
