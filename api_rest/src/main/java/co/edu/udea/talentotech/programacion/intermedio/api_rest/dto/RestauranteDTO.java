package co.edu.udea.talentotech.programacion.intermedio.api_rest.dto;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Restaurante;

public class RestauranteDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String categoria;

    public RestauranteDTO() {}

    public RestauranteDTO(Long id, String nombre, String direccion, String telefono, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
    }

    public RestauranteDTO(Restaurante restaurante) {
        if (restaurante == null) {
            throw new IllegalArgumentException("El restaurante no puede ser null");
        }
    this.id = restaurante.getId();
    this.nombre = restaurante.getNombre();
    this.direccion = restaurante.getDireccion();
    this.telefono = restaurante.getTelefono();
    this.categoria = restaurante.getCategoria();
}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
