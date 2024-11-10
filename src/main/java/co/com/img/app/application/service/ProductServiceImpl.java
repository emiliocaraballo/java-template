package co.com.img.app.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.img.app.application.interfaces.ProductService;
import co.com.img.app.domain.model.Product;
import co.com.img.app.domain.ports.inound.CreateProductUseCase;
import co.com.img.app.domain.ports.inound.GetProductDetailsUseCase;
import co.com.img.app.domain.ports.inound.ListProductsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductServiceImpl implements ProductService {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductDetailsUseCase getProductDetailsUseCase;
    private final ListProductsUseCase listProductsUseCase;
    
    @Override
    public Product create(Product product) {
        return createProductUseCase.execute(product);
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return getProductDetailsUseCase.execute(productId);
    }

    @Override
    public List<Product> listProducts() {
        log.info("Iniciando lista de productos listProductsUseCase");
        return listProductsUseCase.execute();
    }
}