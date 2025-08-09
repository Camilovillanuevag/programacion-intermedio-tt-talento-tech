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

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.UsuarioDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> getUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<UsuarioDTO> getUsuarioByCedula(@PathVariable String cedula) {
        return ResponseEntity.ok(usuarioService.findByCedula(cedula));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO created = usuarioService.save(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable String cedula, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO updated = usuarioService.update(cedula, usuarioDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String cedula) {
        usuarioService.delete(cedula);
        return ResponseEntity.noContent().build();
    }
}
