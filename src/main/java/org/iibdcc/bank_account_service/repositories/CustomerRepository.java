package org.iibdcc.bank_account_service.repositories;

import org.iibdcc.bank_account_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
