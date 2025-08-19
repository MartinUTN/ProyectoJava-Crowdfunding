package modelo;

import java.util.Date;

public class Arrepentimiento_Donacion {
    private int idArrepentimiento;
    private int idDonacion;
    private String motivo;
    private Date fecha;

    public Arrepentimiento_Donacion(int idArrepentimiento, int idDonacion, String motivo, Date fecha) {
        this.idArrepentimiento = idArrepentimiento;
        this.idDonacion = idDonacion;
        this.motivo = motivo;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdArrepentimiento() {
        return idArrepentimiento;
    }

    public void setIdArrepentimiento(int idArrepentimiento) {
        this.idArrepentimiento = idArrepentimiento;
    }

    public int getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
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
