package co.com.img.app.infrastructure.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.img.app.domain.model.Product;
import co.com.img.app.domain.interfaces.ProductRepositoryPort;
import co.com.img.app.infrastructure.persistence.entity.ProductEntity;
import co.com.img.app.infrastructure.persistence.repository.ProductRepositoryJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductRepositoryJpa jpaProductRepository;

    @Override
    public Optional<Product> save(Product product) {
        ProductEntity savedEntity = jpaProductRepository.save(ProductEntity.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .urlImage(product.getImageUrl())
                .build());

        return Optional.of(new Product(savedEntity.getId(), savedEntity.getName(), savedEntity.getDescription(),
                savedEntity.getUrlImage(), savedEntity.getPrice(), savedEntity.getStock()));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaProductRepository.findById(id)
                .map(entity -> new Product(entity.getId(), entity.getName(),
                        entity.getDescription() == null ? "" : entity.getDescription(), entity.getUrlImage(),
                        entity.getPrice(), entity.getStock()));
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream()
                .map(entity -> new Product(entity.getId(), entity.getName(),
                        entity.getDescription() == null ? "" : entity.getDescription(), entity.getUrlImage(),
                        entity.getPrice(), entity.getStock()))
                .collect(Collectors.toList());
    }
}
