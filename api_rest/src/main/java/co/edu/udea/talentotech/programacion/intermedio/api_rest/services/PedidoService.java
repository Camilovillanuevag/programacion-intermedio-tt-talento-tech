package co.edu.udea.talentotech.programacion.intermedio.api_rest.services;

import java.util.List;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.PedidoDTO;

public interface PedidoService {
    List<PedidoDTO> findAll();
    PedidoDTO findById(Integer idPedido);
    PedidoDTO save(PedidoDTO pedidoDTO);
    PedidoDTO update(Integer idPedido, PedidoDTO pedidoDTO);
    void delete(Integer idPedido);
    List<PedidoDTO> findByUsuario(String idUsuario);
}
