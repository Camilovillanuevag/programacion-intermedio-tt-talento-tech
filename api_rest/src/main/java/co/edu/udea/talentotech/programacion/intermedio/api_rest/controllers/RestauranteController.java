package co.edu.udea.talentotech.programacion.intermedio.api_rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.dto.RestauranteDTO;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.services.RestauranteService;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<RestauranteDTO> getAllRestaurantes() {
        return restauranteService.findAll();
    }

    @GetMapping("/{id}")
    public RestauranteDTO getRestauranteById(@PathVariable Long id) {
        return restauranteService.findById(id);
    }

    @PostMapping
    public RestauranteDTO createRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        return restauranteService.save(restauranteDTO);
    }

    @PutMapping("/{id}")
    public RestauranteDTO updateRestaurante(@PathVariable Long id, @RequestBody RestauranteDTO restauranteDTO) {
        return restauranteService.update(id, restauranteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurante(@PathVariable Long id) {
        restauranteService.delete(id);
    }
}
