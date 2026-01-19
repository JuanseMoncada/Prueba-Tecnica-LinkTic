package Requerimiento.LinkTic.LinkTic.Repository;

import Requerimiento.LinkTic.LinkTic.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Producto, Long> {
}
