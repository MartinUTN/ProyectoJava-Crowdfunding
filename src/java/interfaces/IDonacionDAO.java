package interfaces;

import java.util.List;
import modelo.Donacion;

public interface IDonacionDAO {
    
    public List<Donacion> obtenerTodos();
    
    public Donacion obtenerPorId(int id);
    
    public void insertar(Donacion donacion);
    
    public void actualizar(Donacion donacion);
    
    public void eliminar(int id);
}
