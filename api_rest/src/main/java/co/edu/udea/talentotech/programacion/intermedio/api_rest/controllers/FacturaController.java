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

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.FacturaDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.FacturaService;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<FacturaDTO> getAll() {
        return facturaService.findAll();
    }

    @GetMapping("/{idFactura}")
    public ResponseEntity<FacturaDTO> getById(@PathVariable Integer idFactura) {
        return ResponseEntity.ok(facturaService.findById(idFactura));
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<FacturaDTO>> getByUsuario(@PathVariable String idUsuario) {
        return ResponseEntity.ok(facturaService.findByUsuario(idUsuario));
    }

    @PostMapping
    public ResponseEntity<FacturaDTO> create(@RequestBody FacturaDTO dto) {
        FacturaDTO created = facturaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{idFactura}")
    public ResponseEntity<FacturaDTO> update(@PathVariable Integer idFactura, @RequestBody FacturaDTO dto) {
        FacturaDTO updated = facturaService.update(idFactura, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{idFactura}")
    public ResponseEntity<Void> delete(@PathVariable Integer idFactura) {
        facturaService.delete(idFactura);
        return ResponseEntity.noContent().build();
    }
}
