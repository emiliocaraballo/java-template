package co.com.img.app.infrastructure.adapter.in.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import co.com.img.app.application.interfaces.ProductServicePort;
import co.com.img.app.domain.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@RestController
@RequestMapping("${application.request.mappings}/v1/products")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Validated
@Slf4j
public class ProductController {

    private final ProductServicePort productService;

    @GetMapping()
    public Flux<Product> listProducts() {
        log.info("Iniciando lista de productos");
        List<Product> products = productService.listProducts();
        return Flux.fromIterable(products);
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductDetails(@PathVariable Long id) {
        return Mono.justOrEmpty(productService.getProductById(id));
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {
        return Mono.just(productService.create(product));
    }
}
