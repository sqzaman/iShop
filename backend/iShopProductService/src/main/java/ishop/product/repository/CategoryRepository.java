package ishop.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ishop.product.domain.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
	 Boolean existsByName(String name);
}
