package shop.customers.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.customers.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
