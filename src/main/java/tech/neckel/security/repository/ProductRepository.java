
package tech.neckel.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.neckel.security.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
