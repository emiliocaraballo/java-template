package co.com.img.app.application.usecase.product;

import org.springframework.stereotype.Service;

import co.com.img.app.domain.model.Product;
import co.com.img.app.domain.ports.inound.GetProductDetailsUseCase;
import co.com.img.app.domain.ports.outbound.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GetProductDetailsUseCaseImpl implements GetProductDetailsUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public Optional<Product> execute(Long productId) {
        return productRepositoryPort.findById(productId);
    }
}
