package co.edu.udea.talentotech.programacion.intermedio.api_rest.dto;

import java.math.BigDecimal;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.DetalleFactura;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.DetalleFacturaId;

public class DetalleFacturaDTO {

    private Integer idFacturaEnDetalle;
    private Integer idPlatoEnDetalle;
    private Integer cantidad;
    private BigDecimal subtotal;

    public DetalleFacturaDTO() {}

    public DetalleFacturaDTO(Integer idFacturaEnDetalle, Integer idPlatoEnDetalle, Integer cantidad, BigDecimal subtotal) {
        this.idFacturaEnDetalle = idFacturaEnDetalle;
        this.idPlatoEnDetalle = idPlatoEnDetalle;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetalleFacturaDTO(DetalleFactura detalle) {
        DetalleFacturaId id = detalle.getId();
        if (id != null) {
            this.idFacturaEnDetalle = id.getIdFacturaEnDetalle();
            this.idPlatoEnDetalle = id.getIdPlatoEnDetalle();
        }
        this.cantidad = detalle.getCantidad();
        this.subtotal = detalle.getSubtotal();
    }

    // Getters & Setters

    public Integer getIdFacturaEnDetalle() {
        return idFacturaEnDetalle;
    }

    public void setIdFacturaEnDetalle(Integer idFacturaEnDetalle) {
        this.idFacturaEnDetalle = idFacturaEnDetalle;
    }

    public Integer getIdPlatoEnDetalle() {
        return idPlatoEnDetalle;
    }

    public void setIdPlatoEnDetalle(Integer idPlatoEnDetalle) {
        this.idPlatoEnDetalle = idPlatoEnDetalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
