package ishop.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ishop.customers.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Boolean existsByEmail(String email);
	
	Customer findByEmail(String email);

}
