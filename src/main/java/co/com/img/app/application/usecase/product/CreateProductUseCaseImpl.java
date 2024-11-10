package co.com.img.app.application.usecase.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.img.app.domain.model.Product;
import co.com.img.app.domain.ports.inound.CreateProductUseCase;
import co.com.img.app.domain.ports.outbound.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public Product execute(Product product) {
        return productRepositoryPort.save(product).orElseThrow(() -> new RuntimeException("Error saving product"));
    }
}