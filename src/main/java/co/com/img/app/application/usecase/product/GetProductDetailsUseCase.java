package co.com.img.app.application.usecase.product;

import org.springframework.stereotype.Service;

import co.com.img.app.domain.model.Product;
import co.com.img.app.domain.interfaces.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GetProductDetailsUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public Optional<Product> execute(Long productId) {
        return productRepositoryPort.findById(productId);
    }
}
