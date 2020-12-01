package com.springjpa.repo;

import com.springjpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CustomerRepository  extends CrudRepository<Customer, Long> {
}
