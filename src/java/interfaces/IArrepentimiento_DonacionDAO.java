package interfaces;

import java.sql.SQLException;
import modelo.Arrepentimiento_Donacion;

public interface IArrepentimiento_DonacionDAO {
    void guardar(Arrepentimiento_Donacion arrepentimiento) throws SQLException;
}
