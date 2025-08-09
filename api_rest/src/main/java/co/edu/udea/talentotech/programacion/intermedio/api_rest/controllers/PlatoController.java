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

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.PlatoDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.PlatoService;

@RestController
@RequestMapping("/api/platos")
@CrossOrigin(origins = "*")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping
    public List<PlatoDTO> getAll() {
        return platoService.findAll();
    }

    @GetMapping("/{idPlato}")
    public ResponseEntity<PlatoDTO> getById(@PathVariable Integer idPlato) {
        return ResponseEntity.ok(platoService.findById(idPlato));
    }

    @GetMapping("/restaurante/{idRestaurante}")
    public ResponseEntity<List<PlatoDTO>> getByRestaurante(@PathVariable Integer idRestaurante) {
        return ResponseEntity.ok(platoService.findByRestaurante(idRestaurante));
    }

    @PostMapping
    public ResponseEntity<PlatoDTO> create(@RequestBody PlatoDTO dto) {
        PlatoDTO created = platoService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{idPlato}")
    public ResponseEntity<PlatoDTO> update(@PathVariable Integer idPlato, @RequestBody PlatoDTO dto) {
        PlatoDTO updated = platoService.update(idPlato, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{idPlato}")
    public ResponseEntity<Void> delete(@PathVariable Integer idPlato) {
        platoService.delete(idPlato);
        return ResponseEntity.noContent().build();
    }
}