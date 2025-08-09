package co.edu.udea.talentotech.programacion.intermedio.api_rest.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Column(name = "ID_pedido", nullable = false)
    private Integer idPedido;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "ID_usuario_en_pedido", length = 20)
    private String idUsuarioEnPedido;

    public Pedido() {}

    public Pedido(Integer idPedido, Integer cantidad, LocalDate fechaPedido, LocalDate fechaEntrega, String idUsuarioEnPedido) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.idUsuarioEnPedido = idUsuarioEnPedido;
    }

    // Getters y Setters

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getIdUsuarioEnPedido() {
        return idUsuarioEnPedido;
    }

    public void setIdUsuarioEnPedido(String idUsuarioEnPedido) {
        this.idUsuarioEnPedido = idUsuarioEnPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", cantidad=" + cantidad +
                ", fechaPedido=" + fechaPedido +
                ", fechaEntrega=" + fechaEntrega +
                ", idUsuarioEnPedido='" + idUsuarioEnPedido + '\'' +
                '}';
    }
}
