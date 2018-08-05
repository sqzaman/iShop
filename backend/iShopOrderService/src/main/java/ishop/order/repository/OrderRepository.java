package ishop.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ishop.order.domain.Order;


public interface OrderRepository extends MongoRepository<Order, String> {

}
