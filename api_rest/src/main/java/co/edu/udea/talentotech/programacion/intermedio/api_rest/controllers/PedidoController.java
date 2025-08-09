package co.edu.udea.talentotech.programacion.intermedio.api_rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.PedidoDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoDTO> getAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<PedidoDTO> getById(@PathVariable Integer idPedido) {
        return ResponseEntity.ok(pedidoService.findById(idPedido));
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<PedidoDTO>> getByUsuario(@PathVariable String idUsuario) {
        return ResponseEntity.ok(pedidoService.findByUsuario(idUsuario));
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> create(@RequestBody PedidoDTO dto) {
        PedidoDTO created = pedidoService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{idPedido}")
    public ResponseEntity<PedidoDTO> update(@PathVariable Integer idPedido, @RequestBody PedidoDTO dto) {
        PedidoDTO updated = pedidoService.update(idPedido, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{idPedido}")
    public ResponseEntity<Void> delete(@PathVariable Integer idPedido) {
        pedidoService.delete(idPedido);
        return ResponseEntity.noContent().build();
    }
}
