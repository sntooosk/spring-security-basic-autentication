package tech.neckel.security.service;

import java.util.List;

import tech.neckel.security.entity.Product;

public interface ProductService {
    List<Product> listAll();

    Product create(Product product);

    Product update(Product product);

    void delete(Long id);
}
