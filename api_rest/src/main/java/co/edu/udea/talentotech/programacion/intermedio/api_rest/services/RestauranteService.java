package co.edu.udea.talentotech.programacion.intermedio.api_rest.services;

import java.util.List;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.RestauranteDTO;

public interface RestauranteService {
    List<RestauranteDTO> findAll();
    RestauranteDTO findById(Long id);
    RestauranteDTO save(RestauranteDTO restauranteDTO);
    RestauranteDTO update(Long id, RestauranteDTO restauranteDTO);
    void delete(Long id);
}
