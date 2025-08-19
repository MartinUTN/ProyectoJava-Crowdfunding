package interfaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Comentario;

public interface IComentarioDAO {
    List<Comentario> obtenerTodosPorProyecto(int idProyecto) throws SQLException;
    void guardar(Comentario comentario) throws SQLException;
}
