package modelo;

import java.util.Date;

public class Donacion {
    private int idDonacion;
    private int idProyecto;
    private int idUsuario;
    private double monto;
    private Date fecha;

    // Constructor que coincide con el DAO
    public Donacion(int idDonacion, int idProyecto, int idUsuario, double monto, Date fecha) {
        this.idDonacion = idDonacion;
        this.idProyecto = idProyecto;
        this.idUsuario = idUsuario;
        this.monto = monto;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
