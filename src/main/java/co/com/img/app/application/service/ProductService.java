package co.com.img.app.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.img.app.application.interfaces.ProductServicePort;
import co.com.img.app.application.usecase.product.CreateProductUseCase;
import co.com.img.app.application.usecase.product.GetProductDetailsUseCase;
import co.com.img.app.application.usecase.product.ListProductsUseCase;
import co.com.img.app.domain.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductService implements ProductServicePort {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductDetailsUseCase getProductDetailsUseCase;
    private final ListProductsUseCase listProductsUseCase;

    public Product create(Product product) {
        return createProductUseCase.execute(product);
    }

    public Optional<Product> getProductById(Long productId) {
        return getProductDetailsUseCase.execute(productId);
    }

    public List<Product> listProducts() {
        log.info("Iniciando lista de productos listProductsUseCase");
        return listProductsUseCase.execute();
    }
}