package co.com.img.app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.img.app.infrastructure.persistence.entity.ProductEntity;

public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, Long> {
}