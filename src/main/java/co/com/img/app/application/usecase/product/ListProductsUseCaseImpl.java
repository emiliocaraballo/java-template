package co.com.img.app.application.usecase.product;

import co.com.img.app.domain.model.Product;
import co.com.img.app.domain.ports.inound.ListProductsUseCase;
import co.com.img.app.domain.ports.outbound.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ListProductsUseCaseImpl implements ListProductsUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public List<Product> execute() {
        return productRepositoryPort.findAll();
    }
}