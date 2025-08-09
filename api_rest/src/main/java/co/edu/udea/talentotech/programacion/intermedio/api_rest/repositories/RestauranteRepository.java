package co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Restaurante;

public interface RestauranteRepository extends CrudRepository<Restaurante, Long> {
}
