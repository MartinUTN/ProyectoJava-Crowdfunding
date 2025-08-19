package interfaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Avance_Proyecto;

public interface IAvance_ProyectoDAO {
    List<Avance_Proyecto> obtenerPorProyecto(int idProyecto) throws SQLException;
    void guardar(Avance_Proyecto avance) throws SQLException;
}
