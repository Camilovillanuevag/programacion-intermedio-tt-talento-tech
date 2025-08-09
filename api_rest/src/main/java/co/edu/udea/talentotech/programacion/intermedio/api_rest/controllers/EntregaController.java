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

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.EntregaDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.EntregaService;

@RestController
@RequestMapping("/api/entregas")
@CrossOrigin(origins = "*")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public List<EntregaDTO> getAll() {
        return entregaService.findAll();
    }

    @GetMapping("/{idEntrega}")
    public ResponseEntity<EntregaDTO> getById(@PathVariable Integer idEntrega) {
        return ResponseEntity.ok(entregaService.findById(idEntrega));
    }

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<List<EntregaDTO>> getByPedido(@PathVariable Integer idPedido) {
        return ResponseEntity.ok(entregaService.findByPedido(idPedido));
    }

    @PostMapping
    public ResponseEntity<EntregaDTO> create(@RequestBody EntregaDTO dto) {
        EntregaDTO created = entregaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{idEntrega}")
    public ResponseEntity<EntregaDTO> update(@PathVariable Integer idEntrega, @RequestBody EntregaDTO dto) {
        EntregaDTO updated = entregaService.update(idEntrega, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{idEntrega}")
    public ResponseEntity<Void> delete(@PathVariable Integer idEntrega) {
        entregaService.delete(idEntrega);
        return ResponseEntity.noContent().build();
    }
}
