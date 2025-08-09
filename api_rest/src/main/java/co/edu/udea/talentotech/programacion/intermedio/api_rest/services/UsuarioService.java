package co.edu.udea.talentotech.programacion.intermedio.api_rest.services;

import java.util.List;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.UsuarioDTO;

public interface UsuarioService {
    List<UsuarioDTO> findAll();
    UsuarioDTO findByCedula(String cedula);
    UsuarioDTO save(UsuarioDTO usuarioDTO);
    UsuarioDTO update(String cedula, UsuarioDTO usuarioDTO);
    void delete(String cedula);
}
