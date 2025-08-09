package co.edu.udea.talentotech.programacion.intermedio.api_rest.controllers;

import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.DetalleFacturaDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.DetalleFacturaService;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/detalle_facturas")
@CrossOrigin(origins = "*")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaService detalleService;

    @GetMapping
    public List<DetalleFacturaDTO> getAll() {
        return detalleService.findAll();
    }

    @GetMapping("/factura/{idFactura}")
    public ResponseEntity<List<DetalleFacturaDTO>> getByFactura(@PathVariable Integer idFactura) {
        return ResponseEntity.ok(detalleService.findByFactura(idFactura));
    }

    @GetMapping("/{idFactura}/{idPlato}")
    public ResponseEntity<DetalleFacturaDTO> getById(@PathVariable Integer idFactura, @PathVariable Integer idPlato) {
        return ResponseEntity.ok(detalleService.findById(idFactura, idPlato));
    }

    @PostMapping
    public ResponseEntity<DetalleFacturaDTO> create(@RequestBody DetalleFacturaDTO dto) {
        DetalleFacturaDTO created = detalleService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{idFactura}/{idPlato}")
    public ResponseEntity<DetalleFacturaDTO> update(@PathVariable Integer idFactura,
                                                    @PathVariable Integer idPlato,
                                                    @RequestBody DetalleFacturaDTO dto) {
        DetalleFacturaDTO updated = detalleService.update(idFactura, idPlato, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{idFactura}/{idPlato}")
    public ResponseEntity<Void> delete(@PathVariable Integer idFactura, @PathVariable Integer idPlato) {
        detalleService.delete(idFactura, idPlato);
        return ResponseEntity.noContent().build();
    }
}
