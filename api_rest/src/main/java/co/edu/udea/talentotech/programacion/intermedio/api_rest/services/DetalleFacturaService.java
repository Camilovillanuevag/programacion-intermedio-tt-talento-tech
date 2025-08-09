package co.edu.udea.talentotech.programacion.intermedio.api_rest.services;

import java.util.List;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.DetalleFacturaDTO;

public interface DetalleFacturaService {
    List<DetalleFacturaDTO> findAll();
    DetalleFacturaDTO findById(Integer idFactura, Integer idPlato);
    DetalleFacturaDTO save(DetalleFacturaDTO detalleDTO);
    DetalleFacturaDTO update(Integer idFactura, Integer idPlato, DetalleFacturaDTO detalleDTO);
    void delete(Integer idFactura, Integer idPlato);
    List<DetalleFacturaDTO> findByFactura(Integer idFactura);
}
