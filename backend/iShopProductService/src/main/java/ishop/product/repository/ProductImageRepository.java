package ishop.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ishop.product.domain.Category;
import ishop.product.domain.ProductImage;


public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
	 //Boolean existsByName(String name);
}
