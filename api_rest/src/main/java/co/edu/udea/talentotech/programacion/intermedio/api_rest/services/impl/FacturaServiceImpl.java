package co.edu.udea.talentotech.programacion.intermedio.api_rest.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.FacturaDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Factura;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories.FacturaRepository;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<FacturaDTO> findAll() {
        Iterable<Factura> iterable = facturaRepository.findAll();
        List<Factura> list = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        return list.stream().map(factura -> convertToDTO(factura)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public FacturaDTO findById(Integer idFactura) {
        Factura factura = facturaRepository.findById(idFactura)
                .orElseThrow(() -> new RuntimeException("Factura not found with id: " + idFactura));
        return convertToDTO(factura);
    }

    @Transactional
    @Override
    public FacturaDTO save(FacturaDTO facturaDTO) {
        Factura factura = convertToEntity(facturaDTO);
        Factura saved = facturaRepository.save(factura);
        return convertToDTO(saved);
    }

    @Transactional
    @Override
    public FacturaDTO update(Integer idFactura, FacturaDTO facturaDTO) {
        Factura factura = facturaRepository.findById(idFactura)
                .orElseThrow(() -> new RuntimeException("Factura not found with id: " + idFactura));

        if (facturaDTO.getIdUsuarioEnFactura() != null) {
            factura.setIdUsuarioEnFactura(facturaDTO.getIdUsuarioEnFactura());
        }
        if (facturaDTO.getFechaFactura() != null) {
            factura.setFechaFactura(facturaDTO.getFechaFactura());
        }
        if (facturaDTO.getTotal() != null) {
            factura.setTotal(facturaDTO.getTotal());
        }

        Factura updated = facturaRepository.save(factura);
        return convertToDTO(updated);
    }

    @Transactional
    @Override
    public void delete(Integer idFactura) {
        facturaRepository.deleteById(idFactura);
    }

    @Transactional(readOnly = true)
    @Override
    public List<FacturaDTO> findByUsuario(String idUsuario) {
        List<Factura> facturas = facturaRepository.findByIdUsuarioEnFactura(idUsuario);
        return facturas.stream().map(factura -> convertToDTO(factura)).collect(Collectors.toList());
    }

    // Helpers
    private FacturaDTO convertToDTO(Factura factura) {
        return new FacturaDTO(factura);
    }

    private Factura convertToEntity(FacturaDTO dto) {
        Factura f = new Factura();
        f.setIdFactura(dto.getIdFactura());
        f.setIdUsuarioEnFactura(dto.getIdUsuarioEnFactura());
        // If date or total are null, set sensible defaults
        f.setFechaFactura(dto.getFechaFactura() != null ? dto.getFechaFactura() : LocalDate.now());
        f.setTotal(dto.getTotal() != null ? dto.getTotal() : BigDecimal.ZERO);
        return f;
    }
}
