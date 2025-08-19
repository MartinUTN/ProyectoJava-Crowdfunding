package modelo;

import java.util.Date;

public class Cancelacion_Proyecto {
    private int idCancelacion;
    private int idProyecto;
    private String motivo;
    private Date fecha;

    public Cancelacion_Proyecto(int idCancelacion, int idProyecto, String motivo, Date fecha) {
        this.idCancelacion = idCancelacion;
        this.idProyecto = idProyecto;
        this.motivo = motivo;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdCancelacion() {
        return idCancelacion;
    }

    public void setIdCancelacion(int idCancelacion) {
        this.idCancelacion = idCancelacion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
