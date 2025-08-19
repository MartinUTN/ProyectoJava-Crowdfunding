package modelo;

import java.util.Date;

public class Proyecto {
    private int idProyecto;
    private int idUsuario;
    private String titulo;
    private String descripcion;
    private double montoMeta;
    private double montoActual;
    private Date fechaInicio;
    private Date fechaFin;
    private int idCategoria;

    // Constructor que coincide con el DAO
    public Proyecto(int idProyecto, int idUsuario, String titulo, String descripcion, double montoMeta, double montoActual, Date fechaInicio, Date fechaFin, int idCategoria) {
        this.idProyecto = idProyecto;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.montoMeta = montoMeta;
        this.montoActual = montoActual;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idCategoria = idCategoria;
    }

    // Getters y Setters
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMontoMeta() {
        return montoMeta;
    }

    public void setMontoMeta(double montoMeta) {
        this.montoMeta = montoMeta;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(double montoActual) {
        this.montoActual = montoActual;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
