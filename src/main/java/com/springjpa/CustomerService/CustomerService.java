package com.springjpa.CustomerService;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository){
        this.repository=repository;
    }

    public List<Customer> getAllCustomer(){
        List<Customer> customers= new ArrayList<>();
        repository.findAll()
                .forEach(customers::add);
        return customers;
    }
    public Customer getCustomerById(Long id){
        Optional<Customer> possibleCustomer=repository.findById(id);
        if(possibleCustomer.isPresent()) {
            return possibleCustomer.get();
        }
        return new Customer(666L, "Nick", "Stuivenberg");
    }
    public void addCustomer (Customer customer){
        repository.save(customer);
    }
    public void updateCustomer(Long id, Customer customer){
        repository.save(customer);
    }
    public void deleteCustomer (Long id){
        repository.deleteById(id);
    }
}
