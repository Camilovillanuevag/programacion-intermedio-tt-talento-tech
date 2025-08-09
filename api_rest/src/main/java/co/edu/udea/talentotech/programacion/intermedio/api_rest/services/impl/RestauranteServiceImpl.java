package co.edu.udea.talentotech.programacion.intermedio.api_rest.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.RestauranteDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Restaurante;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories.RestauranteRepository;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.RestauranteService;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<RestauranteDTO> findAll() {
        Iterable<Restaurante> iterable = restauranteRepository.findAll();
        List<Restaurante> all = StreamSupport.stream(iterable.spliterator(), false)
                                             .collect(Collectors.toList());
        return all.stream()
                  .map((Restaurante r) -> convertToDTO(r))
                  .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public RestauranteDTO findById(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante not found with id: " + id));
        return convertToDTO(restaurante);
    }

    @Transactional
    @Override
    public RestauranteDTO save(RestauranteDTO restauranteDTO) {
        Restaurante restaurante = convertToEntity(restauranteDTO);
        Restaurante saved = restauranteRepository.save(restaurante);
        return convertToDTO(saved);
    }

    @Transactional
    @Override
    public RestauranteDTO update(Long id, RestauranteDTO restauranteDTO) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante not found with id: " + id));

        restaurante.setNombre(restauranteDTO.getNombre());
        restaurante.setDireccion(restauranteDTO.getDireccion());
        restaurante.setTelefono(restauranteDTO.getTelefono());
        restaurante.setCategoria(restauranteDTO.getCategoria());

        Restaurante updated = restauranteRepository.save(restaurante);
        return convertToDTO(updated);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        restauranteRepository.deleteById(id);
    }

    private RestauranteDTO convertToDTO(Restaurante restaurante) {
        return new RestauranteDTO(restaurante);
    }

    private Restaurante convertToEntity(RestauranteDTO dto) {
        Restaurante r = new Restaurante();
        r.setId(dto.getId());
        r.setNombre(dto.getNombre());
        r.setDireccion(dto.getDireccion());
        r.setTelefono(dto.getTelefono());
        r.setCategoria(dto.getCategoria());
        return r;
    }
}
