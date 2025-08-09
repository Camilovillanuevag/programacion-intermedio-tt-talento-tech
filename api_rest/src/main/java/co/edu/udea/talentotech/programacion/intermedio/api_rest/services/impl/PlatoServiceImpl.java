package co.edu.udea.talentotech.programacion.intermedio.api_rest.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.PlatoDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Plato;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories.PlatoRepository;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.PlatoService;


@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PlatoDTO> findAll() {
        Iterable<Plato> iterable = platoRepository.findAll();
        List<Plato> list = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        return list.stream().map((Plato p) -> convertToDTO(p)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public PlatoDTO findById(Integer idPlato) {
        Plato plato = platoRepository.findById(idPlato)
                .orElseThrow(() -> new RuntimeException("Plato not found with id: " + idPlato));
        return convertToDTO(plato);
    }

    @Transactional
    @Override
    public PlatoDTO save(PlatoDTO platoDTO) {
        Plato plato = convertToEntity(platoDTO);
        // Si deseas generar el id automáticamente, cambia la entidad (ver nota).
        Plato saved = platoRepository.save(plato);
        return convertToDTO(saved);
    }

    @Transactional
    @Override
    public PlatoDTO update(Integer idPlato, PlatoDTO platoDTO) {
        Plato plato = platoRepository.findById(idPlato)
                .orElseThrow(() -> new RuntimeException("Plato not found with id: " + idPlato));

        if (platoDTO.getNombrePlato() != null) {
            plato.setNombrePlato(platoDTO.getNombrePlato());
        }
        if (platoDTO.getPrecio() != null) {
            plato.setPrecio(platoDTO.getPrecio());
        }
        if (platoDTO.getIdRestauranteEnPlato() != null) {
            plato.setIdRestauranteEnPlato(platoDTO.getIdRestauranteEnPlato());
        }

        Plato updated = platoRepository.save(plato);
        return convertToDTO(updated);
    }

    @Transactional
    @Override
    public void delete(Integer idPlato) {
        platoRepository.deleteById(idPlato);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PlatoDTO> findByRestaurante(Integer idRestaurante) {
        List<Plato> platos = platoRepository.findByIdRestauranteEnPlato(idRestaurante);
        return platos.stream().map((Plato p) -> convertToDTO(p)).collect(Collectors.toList());
    }

    // Helpers
    private PlatoDTO convertToDTO(Plato plato) {
        return new PlatoDTO(plato);
    }

    private Plato convertToEntity(PlatoDTO dto) {
        Plato p = new Plato();
        p.setIdPlato(dto.getIdPlato());
        p.setNombrePlato(dto.getNombrePlato());
        p.setPrecio(dto.getPrecio() != null ? dto.getPrecio() : BigDecimal.ZERO);
        p.setIdRestauranteEnPlato(dto.getIdRestauranteEnPlato());
        return p;
    }
}
