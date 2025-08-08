package modelo;

import java.util.Date;

public class Cliente extends Usuario {
    
    public Cliente(String email, String contrasenia, String nombre, String apellido,
                   String telefono, Date fechaNacimiento) {
        super(email, contrasenia, nombre, apellido);
        this.setTelefono(telefono);
        this.setFechaNacimiento(fechaNacimiento);
    }

    public Cliente(int idUsuario, String email, String contrasenia, String nombre, String apellido,
                   String telefono, Date fechaNacimiento) {
        super(idUsuario, email, contrasenia, nombre, apellido, telefono, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idUsuario=" + getIdUsuario() +
                ", email='" + getEmail() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", fechaNacimiento=" + getFechaNacimiento() +
                '}';
    }
}
