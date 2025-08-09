package co.edu.udea.talentotech.programacion.intermedio.api_rest.services;

import java.util.List;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.EntregaDTO;


public interface EntregaService {
    List<EntregaDTO> findAll();
    EntregaDTO findById(Integer idEntrega);
    EntregaDTO save(EntregaDTO entregaDTO);
    EntregaDTO update(Integer idEntrega, EntregaDTO entregaDTO);
    void delete(Integer idEntrega);
    List<EntregaDTO> findByPedido(Integer idPedido);
}
