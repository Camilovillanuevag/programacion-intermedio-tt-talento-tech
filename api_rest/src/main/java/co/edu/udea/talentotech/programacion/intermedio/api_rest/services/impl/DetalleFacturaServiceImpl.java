package co.edu.udea.talentotech.programacion.intermedio.api_rest.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.DetalleFacturaDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.DetalleFactura;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.DetalleFacturaId;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories.DetalleFacturaRepository;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.DetalleFacturaService;


@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleRepository;

    @Transactional(readOnly = true)
    @Override
    public List<DetalleFacturaDTO> findAll() {
        Iterable<DetalleFactura> iterable = detalleRepository.findAll();
        List<DetalleFactura> list = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        return list.stream().map(detalle -> convertToDTO(detalle)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public DetalleFacturaDTO findById(Integer idFactura, Integer idPlato) {
        DetalleFacturaId id = new DetalleFacturaId(idFactura, idPlato);
        DetalleFactura detalle = detalleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleFactura not found: " + id));
        return convertToDTO(detalle);
    }

    @Transactional
    @Override
    public DetalleFacturaDTO save(DetalleFacturaDTO detalleDTO) {
        DetalleFactura detalle = convertToEntity(detalleDTO);
        DetalleFactura saved = detalleRepository.save(detalle);
        return convertToDTO(saved);
    }

    @Transactional
    @Override
    public DetalleFacturaDTO update(Integer idFactura, Integer idPlato, DetalleFacturaDTO detalleDTO) {
        DetalleFacturaId id = new DetalleFacturaId(idFactura, idPlato);
        DetalleFactura detalle = detalleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleFactura not found: " + id));

        if (detalleDTO.getCantidad() != null) {
            detalle.setCantidad(detalleDTO.getCantidad());
        }
        if (detalleDTO.getSubtotal() != null) {
            detalle.setSubtotal(detalleDTO.getSubtotal());
        }

        DetalleFactura updated = detalleRepository.save(detalle);
        return convertToDTO(updated);
    }

    @Transactional
    @Override
    public void delete(Integer idFactura, Integer idPlato) {
        DetalleFacturaId id = new DetalleFacturaId(idFactura, idPlato);
        detalleRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<DetalleFacturaDTO> findByFactura(Integer idFactura) {
        List<DetalleFactura> detalles = detalleRepository.findById_IdFacturaEnDetalle(idFactura);
        return detalles.stream().map((DetalleFactura d) -> convertToDTO(d)).collect(Collectors.toList());
    }

    // Helpers
    private DetalleFacturaDTO convertToDTO(DetalleFactura detalle) {
        return new DetalleFacturaDTO(detalle);
    }

    private DetalleFactura convertToEntity(DetalleFacturaDTO dto) {
        Integer idFactura = dto.getIdFacturaEnDetalle();
        Integer idPlato = dto.getIdPlatoEnDetalle();

        DetalleFacturaId id = new DetalleFacturaId(idFactura, idPlato);
        DetalleFactura d = new DetalleFactura();
        d.setId(id);
        d.setCantidad(dto.getCantidad());
        d.setSubtotal(dto.getSubtotal() != null ? dto.getSubtotal() : BigDecimal.ZERO);
        return d;
    }
}
