package co.edu.udea.talentotech.programacion.intermedio.api_rest.dto;

import java.time.LocalDate;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Pedido;


public class PedidoDTO {
    private Integer idPedido;
    private Integer cantidad;
    private LocalDate fechaPedido;
    private LocalDate fechaEntrega;
    private String idUsuarioEnPedido;

    public PedidoDTO() {}

    public PedidoDTO(Integer idPedido, Integer cantidad, LocalDate fechaPedido, LocalDate fechaEntrega, String idUsuarioEnPedido) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.idUsuarioEnPedido = idUsuarioEnPedido;
    }

    public PedidoDTO(Pedido pedido) {
        if (pedido != null) {
            this.idPedido = pedido.getIdPedido();
            this.cantidad = pedido.getCantidad();
            this.fechaPedido = pedido.getFechaPedido();
            this.fechaEntrega = pedido.getFechaEntrega();
            this.idUsuarioEnPedido = pedido.getIdUsuarioEnPedido();
        }
    }

    // Getters & Setters

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
}
