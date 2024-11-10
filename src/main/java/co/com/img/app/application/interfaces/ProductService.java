package co.com.img.app.application.interfaces;

import java.util.List;
import java.util.Optional;

import co.com.img.app.domain.model.Product;

public interface ProductService {

    public Product create(Product product);

    public Optional<Product> getProductById(Long productId);

    public List<Product> listProducts();
}
