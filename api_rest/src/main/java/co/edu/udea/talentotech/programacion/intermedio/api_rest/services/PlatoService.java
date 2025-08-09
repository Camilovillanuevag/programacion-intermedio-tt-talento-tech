package co.edu.udea.talentotech.programacion.intermedio.api_rest.services;

import java.util.List;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.PlatoDTO;


public interface PlatoService {
    List<PlatoDTO> findAll();
    PlatoDTO findById(Integer idPlato);
    PlatoDTO save(PlatoDTO platoDTO);
    PlatoDTO update(Integer idPlato, PlatoDTO platoDTO);
    void delete(Integer idPlato);
    List<PlatoDTO> findByRestaurante(Integer idRestaurante);
}
