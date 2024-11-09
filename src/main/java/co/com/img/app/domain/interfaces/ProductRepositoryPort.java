package co.com.img.app.domain.interfaces;

import co.com.img.app.domain.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Optional<Product> save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
}