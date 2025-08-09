package co.edu.udea.talentotech.programacion.intermedio.api_rest.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {

    @EmbeddedId
    private DetalleFacturaId id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    public DetalleFactura() {}

    public DetalleFactura(DetalleFacturaId id, Integer cantidad, BigDecimal subtotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetalleFacturaId getId() {
        return id;
    }

    public void setId(DetalleFacturaId id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }
}
