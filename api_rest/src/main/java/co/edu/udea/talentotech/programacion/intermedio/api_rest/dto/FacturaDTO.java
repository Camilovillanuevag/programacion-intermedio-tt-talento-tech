package co.edu.udea.talentotech.programacion.intermedio.api_rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Factura;


public class FacturaDTO {
    private Integer idFactura;
    private String idUsuarioEnFactura;
    private LocalDate fechaFactura;
    private BigDecimal total;

    public FacturaDTO() {}

    public FacturaDTO(Integer idFactura, String idUsuarioEnFactura, LocalDate fechaFactura, BigDecimal total) {
        this.idFactura = idFactura;
        this.idUsuarioEnFactura = idUsuarioEnFactura;
        this.fechaFactura = fechaFactura;
        this.total = total;
    }

    public FacturaDTO(Factura factura) {
        if (factura != null) {
            this.idFactura = factura.getIdFactura();
            this.idUsuarioEnFactura = factura.getIdUsuarioEnFactura();
            this.fechaFactura = factura.getFechaFactura();
            this.total = factura.getTotal();
        }
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
}
