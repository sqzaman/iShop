package ishop.product.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import ishop.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByProductId(String productId);
}
