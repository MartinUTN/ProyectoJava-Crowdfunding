package modelo;

import java.util.Date;

public class Cliente extends Usuario {
    
    public Cliente(String email, String password, String nombre, String apellido,
                   String telefono, Date fechaNacimiento) {
        super(email, password, nombre, apellido);
        this.setTelefono(telefono);
        this.setFechaNacimiento(fechaNacimiento);
    }

    public Cliente(int idUsuario, String email, String password, String nombre, String apellido,
                   String telefono, Date fechaNacimiento) {
        super(idUsuario, email, password, nombre, apellido, telefono, fechaNacimiento);
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
