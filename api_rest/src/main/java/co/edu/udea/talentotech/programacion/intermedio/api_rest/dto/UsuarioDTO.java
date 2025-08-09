package co.edu.udea.talentotech.programacion.intermedio.api_rest.dto;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Usuario;


public class UsuarioDTO {
    private String cedula;
    private String nombre;
    private String apellido;
    private String apellido2;
    private String correo;
    private String clave;
    private String telefono;
    private String direccion;
    private String rol;

    public UsuarioDTO() {}

    public UsuarioDTO(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public UsuarioDTO(Usuario usuario) {
        this.cedula = usuario.getCedula();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.apellido2 = usuario.getApellido2();
        this.correo = usuario.getCorreo();
        this.clave = usuario.getClave();
        this.telefono = usuario.getTelefono();
        this.direccion = usuario.getDireccion();
        this.rol = usuario.getRol();
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
}
