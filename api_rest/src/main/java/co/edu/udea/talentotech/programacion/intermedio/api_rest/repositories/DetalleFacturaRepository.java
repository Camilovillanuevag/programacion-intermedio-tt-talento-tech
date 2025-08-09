package co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.DetalleFactura;
import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.DetalleFacturaId;

@Repository
public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, DetalleFacturaId> {
    List<DetalleFactura> findById_IdFacturaEnDetalle(Integer idFacturaEnDetalle);
}
