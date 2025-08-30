package interfaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Cliente;

public interface IClienteDAO {
    List<Cliente> obtenerTodos() throws SQLException;
    Cliente obtenerPorId(int id) throws SQLException;
    void guardar(Cliente cliente) throws SQLException;
}
