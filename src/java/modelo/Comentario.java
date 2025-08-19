package modelo;

import java.util.Date;

public class Comentario {
    private int idComentario;
    private int idProyecto;
    private int idUsuario;
    private String texto;
    private Date fecha;

    // Constructor que coincide con el DAO
    public Comentario(int idComentario, int idProyecto, int idUsuario, String texto, Date fecha) {
        this.idComentario = idComentario;
        this.idProyecto = idProyecto;
        this.idUsuario = idUsuario;
        this.texto = texto;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
