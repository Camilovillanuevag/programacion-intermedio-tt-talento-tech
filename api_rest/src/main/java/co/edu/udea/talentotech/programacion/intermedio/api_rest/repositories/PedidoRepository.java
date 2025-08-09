package co.edu.udea.talentotech.programacion.intermedio.api_rest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.udea.talentotech.programacion.intermedio.api_rest.entities.Pedido;


@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
    List<Pedido> findByIdUsuarioEnPedido(String idUsuarioEnPedido);
}
