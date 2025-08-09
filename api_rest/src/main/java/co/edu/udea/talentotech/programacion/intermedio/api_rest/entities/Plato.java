package co.edu.udea.talentotech.programacion.intermedio.api_rest.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "plato")
public class Plato {

    @Id
    @Column(name = "ID_plato", nullable = false)
    private Integer idPlato;

    @Size(max = 100)
    @Column(name = "nombre_plato", length = 100)
    private String nombrePlato;

    @Column(name = "precio", precision = 9, scale = 2)
    private BigDecimal precio;

    @Column(name = "ID_restaurante_en_plato")
    private Integer idRestauranteEnPlato;

    public Plato() {}

    public Plato(Integer idPlato, String nombrePlato, BigDecimal precio, Integer idRestauranteEnPlato) {
        this.idPlato = idPlato;
        this.nombrePlato = nombrePlato;
        this.precio = precio;
        this.idRestauranteEnPlato = idRestauranteEnPlato;
    }

    // Getters & Setters

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getIdRestauranteEnPlato() {
        return idRestauranteEnPlato;
    }

    public void setIdRestauranteEnPlato(Integer idRestauranteEnPlato) {
        this.idRestauranteEnPlato = idRestauranteEnPlato;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "idPlato=" + idPlato +
                ", nombrePlato='" + nombrePlato + '\'' +
                ", precio=" + precio +
                ", idRestauranteEnPlato=" + idRestauranteEnPlato +
                '}';
    }
}
