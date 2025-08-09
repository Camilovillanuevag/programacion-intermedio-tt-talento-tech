package co.edu.udea.talentotech.programacion.intermedio.api_rest.services;

import java.util.List;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.FacturaDTO;

public interface FacturaService {
    List<FacturaDTO> findAll();
    FacturaDTO findById(Integer idFactura);
    FacturaDTO save(FacturaDTO facturaDTO);
    FacturaDTO update(Integer idFactura, FacturaDTO facturaDTO);
    void delete(Integer idFactura);
    List<FacturaDTO> findByUsuario(String idUsuario);
}
