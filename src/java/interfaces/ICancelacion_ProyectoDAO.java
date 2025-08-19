package interfaces;

import java.sql.SQLException;
import modelo.Cancelacion_Proyecto;

public interface ICancelacion_ProyectoDAO {
    void guardar(Cancelacion_Proyecto cancelacion) throws SQLException;
}
