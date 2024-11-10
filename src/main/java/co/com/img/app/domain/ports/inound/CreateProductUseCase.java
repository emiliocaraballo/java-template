package co.com.img.app.domain.ports.inound;

import co.com.img.app.domain.model.Product;

public interface CreateProductUseCase {
    public Product execute(Product product);
}
