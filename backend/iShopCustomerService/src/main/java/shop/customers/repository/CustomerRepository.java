package shop.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.customers.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Boolean existsByEmail(String email);
	Boolean existsByUsername(String username);
}
