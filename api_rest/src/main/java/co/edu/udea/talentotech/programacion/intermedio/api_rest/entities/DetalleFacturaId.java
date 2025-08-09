package co.edu.udea.talentotech.programacion.intermedio.api_rest.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleFacturaId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID_factura_en_detalle")
    private Integer idFacturaEnDetalle;

    @Column(name = "ID_plato_en_detalle")
    private Integer idPlatoEnDetalle;

    public DetalleFacturaId() {}

    public DetalleFacturaId(Integer idFacturaEnDetalle, Integer idPlatoEnDetalle) {
        this.idFacturaEnDetalle = idFacturaEnDetalle;
        this.idPlatoEnDetalle = idPlatoEnDetalle;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleFacturaId that = (DetalleFacturaId) o;
        return Objects.equals(idFacturaEnDetalle, that.idFacturaEnDetalle) &&
               Objects.equals(idPlatoEnDetalle, that.idPlatoEnDetalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacturaEnDetalle, idPlatoEnDetalle);
    }

    @Override
    public String toString() {
        return "DetalleFacturaId{" +
                "idFacturaEnDetalle=" + idFacturaEnDetalle +
                ", idPlatoEnDetalle=" + idPlatoEnDetalle +
                '}';
    }
}
