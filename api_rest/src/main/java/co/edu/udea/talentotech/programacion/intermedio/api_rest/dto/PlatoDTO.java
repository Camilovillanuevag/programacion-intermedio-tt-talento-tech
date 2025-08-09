package co.edu.udea.talentotech.programacion.intermedio.api_rest.dto;

import java.math.BigDecimal;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Plato;

public class PlatoDTO {
    private Integer idPlato;
    private String nombrePlato;
    private BigDecimal precio;
    private Integer idRestauranteEnPlato;

    public PlatoDTO() {}

    public PlatoDTO(Integer idPlato, String nombrePlato, BigDecimal precio, Integer idRestauranteEnPlato) {
        this.idPlato = idPlato;
        this.nombrePlato = nombrePlato;
        this.precio = precio;
        this.idRestauranteEnPlato = idRestauranteEnPlato;
    }

    public PlatoDTO(Plato plato) {
        if (plato != null) {
            this.idPlato = plato.getIdPlato();
            this.nombrePlato = plato.getNombrePlato();
            this.precio = plato.getPrecio();
            this.idRestauranteEnPlato = plato.getIdRestauranteEnPlato();
        }
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
}
