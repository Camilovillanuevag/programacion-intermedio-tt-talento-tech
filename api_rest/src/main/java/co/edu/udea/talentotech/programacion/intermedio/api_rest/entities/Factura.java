package co.edu.udea.talentotech.programacion.intermedio.api_rest.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @Column(name = "ID_factura", nullable = false)
    private Integer idFactura;

    @Column(name = "ID_usuario_en_factura", length = 20)
    private String idUsuarioEnFactura;

    @Column(name = "fecha_factura")
    private LocalDate fechaFactura;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    public Factura() {}

    public Factura(Integer idFactura, String idUsuarioEnFactura, LocalDate fechaFactura, BigDecimal total) {
        this.idFactura = idFactura;
        this.idUsuarioEnFactura = idUsuarioEnFactura;
        this.fechaFactura = fechaFactura;
        this.total = total;
    }

    // Getters & Setters

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdUsuarioEnFactura() {
        return idUsuarioEnFactura;
    }

    public void setIdUsuarioEnFactura(String idUsuarioEnFactura) {
        this.idUsuarioEnFactura = idUsuarioEnFactura;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", idUsuarioEnFactura='" + idUsuarioEnFactura + '\'' +
                ", fechaFactura=" + fechaFactura +
                ", total=" + total +
                '}';
    }
}
