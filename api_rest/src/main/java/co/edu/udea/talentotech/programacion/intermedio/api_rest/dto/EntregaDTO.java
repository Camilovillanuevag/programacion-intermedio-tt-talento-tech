package co.edu.udea.talentotech.programacion.intermedio.api_rest.dto;

import java.time.LocalDate;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Entrega;

public class EntregaDTO {
    private Integer idEntrega;
    private Integer idPedidoEnEntrega;
    private String direccionEntrega;
    private String repartidor;
    private LocalDate fechaEntrega;
    private String estado;

    public EntregaDTO() {}

    public EntregaDTO(Integer idEntrega, Integer idPedidoEnEntrega, String direccionEntrega,
                      String repartidor, LocalDate fechaEntrega, String estado) {
        this.idEntrega = idEntrega;
        this.idPedidoEnEntrega = idPedidoEnEntrega;
        this.direccionEntrega = direccionEntrega;
        this.repartidor = repartidor;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public EntregaDTO(Entrega entrega) {
        if (entrega != null) {
            this.idEntrega = entrega.getIdEntrega();
            this.idPedidoEnEntrega = entrega.getIdPedidoEnEntrega();
            this.direccionEntrega = entrega.getDireccionEntrega();
            this.repartidor = entrega.getRepartidor();
            this.fechaEntrega = entrega.getFechaEntrega();
            this.estado = entrega.getEstado();
        }
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
}
