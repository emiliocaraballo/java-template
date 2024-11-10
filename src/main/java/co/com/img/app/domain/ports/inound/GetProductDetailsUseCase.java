package co.com.img.app.domain.ports.inound;

import java.util.Optional;

import co.com.img.app.domain.model.Product;

public interface GetProductDetailsUseCase {
    public Optional<Product> execute(Long productId);
}
