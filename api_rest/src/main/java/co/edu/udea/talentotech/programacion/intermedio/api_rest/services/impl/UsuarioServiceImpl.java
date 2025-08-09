package co.edu.udea.talentotech.programacion.intermedio.api_rest.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.UsuarioDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Usuario;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories.UsuarioRepository;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<UsuarioDTO> findAll() {
        Iterable<Usuario> iterable = usuarioRepository.findAll();
        List<Usuario> all = StreamSupport.stream(iterable.spliterator(), false)
                                         .collect(Collectors.toList());
        return all.stream()
                  .map(usuario -> convertToDTO(usuario))
                  .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioDTO findByCedula(String cedula) {
        Usuario usuario = usuarioRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Usuario not found with cedula: " + cedula));
        return convertToDTO(usuario);
    }

    @Transactional
    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        Usuario saved = usuarioRepository.save(usuario);
        return convertToDTO(saved);
    }

    @Transactional
    @Override
    public UsuarioDTO update(String cedula, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Usuario not found with cedula: " + cedula));

        // Actualizar solo los campos que vienen en el DTO (no nulos)
        if (usuarioDTO.getNombre() != null) {
            usuario.setNombre(usuarioDTO.getNombre());
        }
        if (usuarioDTO.getApellido() != null) {
            usuario.setApellido(usuarioDTO.getApellido());
        }
        if (usuarioDTO.getApellido2() != null) {
            usuario.setApellido2(usuarioDTO.getApellido2());
        }
        if (usuarioDTO.getCorreo() != null) {
            usuario.setCorreo(usuarioDTO.getCorreo());
        }
        if (usuarioDTO.getClave() != null) {
            usuario.setClave(usuarioDTO.getClave());
        }
        if (usuarioDTO.getTelefono() != null) {
            usuario.setTelefono(usuarioDTO.getTelefono());
        }
        if (usuarioDTO.getDireccion() != null) {
            usuario.setDireccion(usuarioDTO.getDireccion());
        }
        if (usuarioDTO.getRol() != null) {
            usuario.setRol(usuarioDTO.getRol());
        }

        Usuario updated = usuarioRepository.save(usuario);
        return convertToDTO(updated);
    }

    @Transactional
    @Override
    public void delete(String cedula) {
        usuarioRepository.deleteById(cedula);
    }

    // Helpers
    private UsuarioDTO convertToDTO(Usuario usuario) {
        return new UsuarioDTO(usuario);
    }

    private Usuario convertToEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setCedula(dto.getCedula());
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setApellido2(dto.getApellido2());
        u.setCorreo(dto.getCorreo());
        u.setClave(dto.getClave());
        u.setTelefono(dto.getTelefono());
        u.setDireccion(dto.getDireccion());
        u.setRol(dto.getRol());
        return u;
    }
}
