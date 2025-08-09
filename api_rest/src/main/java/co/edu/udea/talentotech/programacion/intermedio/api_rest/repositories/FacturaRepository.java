package co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Factura;


@Repository
public interface FacturaRepository extends CrudRepository<Factura, Integer> {
    List<Factura> findByIdUsuarioEnFactura(String idUsuarioEnFactura);
}
