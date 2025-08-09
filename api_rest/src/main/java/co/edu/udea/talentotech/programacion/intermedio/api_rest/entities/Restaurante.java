package co.edu.udea.talentotech.programacion.intermedio.api_rest.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @Column(name = "ID_restaurante")
    private Long id; // Cambiado a Long

    @Column(name = "nombre_res")
    @Nonnull
    private String nombre;

    @Column(name = "descripcion_res")
    @Nonnull
    private String descripcion;

    @Column(name = "zona")
    @Nonnull
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "categoria")
    private String categoria;

    public Restaurante() {}

    public Restaurante(Long id, String nombre, String descripcion, String direccion, String telefono, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}