package co.edu.udea.talentotech.programacion.intermedio.api_rest.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.PedidoDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Pedido;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories.PedidoRepository;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PedidoDTO> findAll() {
        Iterable<Pedido> iterable = pedidoRepository.findAll();
        List<Pedido> list = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        return list.stream().map((Pedido p) -> convertToDTO(p)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public PedidoDTO findById(Integer idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido not found with id: " + idPedido));
        return convertToDTO(pedido);
    }

    @Transactional
    @Override
    public PedidoDTO save(PedidoDTO pedidoDTO) {
        Pedido pedido = convertToEntity(pedidoDTO);
        // si fechaPedido es null, poner hoy
        if (pedido.getFechaPedido() == null) {
            pedido.setFechaPedido(LocalDate.now());
        }
        Pedido saved = pedidoRepository.save(pedido);
        return convertToDTO(saved);
    }

    @Transactional
    @Override
    public PedidoDTO update(Integer idPedido, PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido not found with id: " + idPedido));

        if (pedidoDTO.getCantidad() != null) {
            pedido.setCantidad(pedidoDTO.getCantidad());
        }
        if (pedidoDTO.getFechaPedido() != null) {
            pedido.setFechaPedido(pedidoDTO.getFechaPedido());
        }
        if (pedidoDTO.getFechaEntrega() != null) {
            pedido.setFechaEntrega(pedidoDTO.getFechaEntrega());
        }
        if (pedidoDTO.getIdUsuarioEnPedido() != null) {
            pedido.setIdUsuarioEnPedido(pedidoDTO.getIdUsuarioEnPedido());
        }

        Pedido updated = pedidoRepository.save(pedido);
        return convertToDTO(updated);
    }

    @Transactional
    @Override
    public void delete(Integer idPedido) {
        pedidoRepository.deleteById(idPedido);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PedidoDTO> findByUsuario(String idUsuario) {
        List<Pedido> pedidos = pedidoRepository.findByIdUsuarioEnPedido(idUsuario);
        return pedidos.stream().map(pedido -> convertToDTO(pedido)).collect(Collectors.toList());
    }

    // Helpers
    private PedidoDTO convertToDTO(Pedido pedido) {
        return new PedidoDTO(pedido);
    }

    private Pedido convertToEntity(PedidoDTO dto) {
        Pedido p = new Pedido();
        p.setIdPedido(dto.getIdPedido());
        p.setCantidad(dto.getCantidad());
        p.setFechaPedido(dto.getFechaPedido());
        p.setFechaEntrega(dto.getFechaEntrega());
        p.setIdUsuarioEnPedido(dto.getIdUsuarioEnPedido());
        return p;
    }
}
