package modelo;

import java.util.Date;

public class Cliente extends Usuario {
    private String telefono;
    private Date fechaNacimiento;

    public Cliente(String email, String contrasenia, String nombre, String apellido,
                   String telefono, Date fechaNacimiento) {
        super(email, contrasenia, nombre, apellido);
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente(int idUsuario, String email, String contrasenia, String nombre, String apellido,
                   String telefono, Date fechaNacimiento) {
        super(idUsuario, email, contrasenia, nombre, apellido);
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idUsuario=" + getIdUsuario() +
                ", email='" + getEmail() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}