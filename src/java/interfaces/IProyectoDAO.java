package interfaces;

import java.util.List;
import modelo.Proyecto;

public interface IProyectoDAO {
    
    public List<Proyecto> obtenerTodos();
    
    public Proyecto obtenerPorId(int id);
    
    public void insertar(Proyecto proyecto);
    
    public void actualizar(Proyecto proyecto);
    
    public void eliminar(int id);
}
