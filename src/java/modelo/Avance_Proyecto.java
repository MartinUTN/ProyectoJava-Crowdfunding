package modelo;

import java.util.Date;

public class Avance_Proyecto {
    private int idAvance;
    private int idProyecto;
    private String descripcion;
    private String foto;
    private Date fecha;

    public Avance_Proyecto(int idAvance, int idProyecto, String descripcion, String foto, Date fecha) {
        this.idAvance = idAvance;
        this.idProyecto = idProyecto;
        this.descripcion = descripcion;
        this.foto = foto;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdAvance() {
        return idAvance;
    }

    public void setIdAvance(int idAvance) {
        this.idAvance = idAvance;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
