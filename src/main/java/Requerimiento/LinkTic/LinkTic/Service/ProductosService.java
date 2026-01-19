package Requerimiento.LinkTic.LinkTic.Service;

import Requerimiento.LinkTic.LinkTic.Entity.Producto;
import Requerimiento.LinkTic.LinkTic.Repository.ProductosRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class ProductosService {

    private final ProductosRepository productosRepository;

    public ProductosService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    public Page<Producto> listar(Pageable pageable) {
        return productosRepository.findAll(pageable);
    }

    public Producto obtenerPorId(Long id) {
        return productosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Producto crear(Producto producto) {
        return productosRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto productoActualizado) {
        Producto producto = obtenerPorId(id);
        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.getPrecio());
        return productosRepository.save(producto);
    }

    public void eliminar(Long id) {
        productosRepository.deleteById(id);
    }
}
