package co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Plato;

@Repository
public interface PlatoRepository extends CrudRepository<Plato, Integer> {
    List<Plato> findByIdRestauranteEnPlato(Integer idRestauranteEnPlato);
}
