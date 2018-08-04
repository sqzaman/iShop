package shop.shopping.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import shop.shopping.domain.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
