package co.com.img.app.domain.ports.inound;

import java.util.List;

import co.com.img.app.domain.model.Product;

public interface ListProductsUseCase {
    public List<Product> execute();
}
