package modelo;

import java.util.Date;

public class Usuario {
    private int idUsuario;
    private String email;
    private String contrasenia;
    private String nombre;
    private String apellido;
    private String telefono;
    private Date fechaNacimiento;

    public Usuario(String email, String contrasenia, String nombre, String apellido) {
        this.email = email;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario(int idUsuario, String email, String contrasenia, String nombre, String apellido, String telefono, Date fechaNacimiento) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
