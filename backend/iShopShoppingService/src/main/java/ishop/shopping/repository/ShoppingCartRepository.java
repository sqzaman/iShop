package ishop.shopping.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import ishop.shopping.domain.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
