package co.edu.udea.talentotech.programacion.intermedio.api_rest.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "entrega")
public class Entrega {

    @Id
    @Column(name = "ID_entrega", nullable = false)
    private Integer idEntrega;

    @Column(name = "ID_pedido_en_entrega")
    private Integer idPedidoEnEntrega;

    @Size(max = 200)
    @Column(name = "direccion_entrega", length = 200)
    private String direccionEntrega;

    @Size(max = 70)
    @Column(name = "repartidor", length = 70)
    private String repartidor;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Size(max = 20)
    @Column(name = "estado", length = 20)
    private String estado;

    public Entrega() {}

    public Entrega(Integer idEntrega, Integer idPedidoEnEntrega, String direccionEntrega,
                   String repartidor, LocalDate fechaEntrega, String estado) {
        this.idEntrega = idEntrega;
        this.idPedidoEnEntrega = idPedidoEnEntrega;
        this.direccionEntrega = direccionEntrega;
        this.repartidor = repartidor;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    // Getters y Setters
    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Integer getIdPedidoEnEntrega() {
        return idPedidoEnEntrega;
    }

    public void setIdPedidoEnEntrega(Integer idPedidoEnEntrega) {
        this.idPedidoEnEntrega = idPedidoEnEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "idEntrega=" + idEntrega +
                ", idPedidoEnEntrega=" + idPedidoEnEntrega +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", repartidor='" + repartidor + '\'' +
                ", fechaEntrega=" + fechaEntrega +
                ", estado='" + estado + '\'' +
                '}';
    }
}
