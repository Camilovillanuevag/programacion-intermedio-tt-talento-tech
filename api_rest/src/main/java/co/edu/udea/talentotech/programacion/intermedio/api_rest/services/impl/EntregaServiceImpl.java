package co.edu.udea.talentotech.programacion.intermedio.api_rest.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.EntregaDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Entrega;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories.EntregaRepository;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.EntregaService;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<EntregaDTO> findAll() {
        Iterable<Entrega> iterable = entregaRepository.findAll();
        List<Entrega> list = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        return list.stream().map((Entrega entrega) -> convertToDTO(entrega)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public EntregaDTO findById(Integer idEntrega) {
        Entrega entrega = entregaRepository.findById(idEntrega)
                .orElseThrow(() -> new RuntimeException("Entrega not found with id: " + idEntrega));
        return convertToDTO(entrega);
    }

    @Transactional
    @Override
    public EntregaDTO save(EntregaDTO entregaDTO) {
        Entrega entrega = convertToEntity(entregaDTO);
        Entrega saved = entregaRepository.save(entrega);
        return convertToDTO(saved);
    }

    @Transactional
    @Override
    public EntregaDTO update(Integer idEntrega, EntregaDTO entregaDTO) {
        Entrega entrega = entregaRepository.findById(idEntrega)
                .orElseThrow(() -> new RuntimeException("Entrega not found with id: " + idEntrega));

        if (entregaDTO.getIdPedidoEnEntrega() != null) {
            entrega.setIdPedidoEnEntrega(entregaDTO.getIdPedidoEnEntrega());
        }
        if (entregaDTO.getDireccionEntrega() != null) {
            entrega.setDireccionEntrega(entregaDTO.getDireccionEntrega());
        }
        if (entregaDTO.getRepartidor() != null) {
            entrega.setRepartidor(entregaDTO.getRepartidor());
        }
        if (entregaDTO.getFechaEntrega() != null) {
            entrega.setFechaEntrega(entregaDTO.getFechaEntrega());
        }
        if (entregaDTO.getEstado() != null) {
            entrega.setEstado(entregaDTO.getEstado());
        }

        Entrega updated = entregaRepository.save(entrega);
        return convertToDTO(updated);
    }

    @Transactional
    @Override
    public void delete(Integer idEntrega) {
        entregaRepository.deleteById(idEntrega);
    }

    @Transactional(readOnly = true)
    @Override
    public List<EntregaDTO> findByPedido(Integer idPedido) {
        List<Entrega> entregas = entregaRepository.findByIdPedidoEnEntrega(idPedido);
        return entregas.stream().map(entrega -> convertToDTO(entrega)).collect(Collectors.toList());
    }

    // Helpers
    private EntregaDTO convertToDTO(Entrega entrega) {
        return new EntregaDTO(entrega);
    }

    private Entrega convertToEntity(EntregaDTO dto) {
        Entrega e = new Entrega();
        e.setIdEntrega(dto.getIdEntrega());
        e.setIdPedidoEnEntrega(dto.getIdPedidoEnEntrega());
        e.setDireccionEntrega(dto.getDireccionEntrega());
        e.setRepartidor(dto.getRepartidor());
        e.setFechaEntrega(dto.getFechaEntrega());
        e.setEstado(dto.getEstado());
        return e;
    }
}
