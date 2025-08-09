package co.edu.udea.talentotech.programacion.intermedio.api_rest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;

    @Size(max = 70)
    @Column(name = "nombre", length = 70)
    private String nombre;

    @Size(max = 50)
    @Column(name = "apellido", length = 50)
    private String apellido;

    @Size(max = 50)
    @Column(name = "apellido2", length = 50)
    private String apellido2;

    @Size(max = 200)
    @Column(name = "correo", length = 200)
    private String correo;

    @Size(max = 200)
    @Column(name = "clave", length = 200)
    private String clave;

    @Size(max = 15)
    @Column(name = "telefono", length = 15)
    private String telefono;

    @Size(max = 200)
    @Column(name = "direccion", length = 200)
    private String direccion;

    @Size(max = 10)
    @Column(name = "rol", length = 10)
    private String rol;

    public Usuario() {}

    public Usuario(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters & Setters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
