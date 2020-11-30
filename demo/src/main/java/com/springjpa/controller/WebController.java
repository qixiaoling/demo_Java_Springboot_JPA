package com.springjpa.controller;

import com.springjpa.CustomerService.CustomerService;
import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util. List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class WebController {
@Autowired
    CustomerService customerService;

public WebController(CustomerService customerService){
    this.customerService=customerService;
}
    @RequestMapping(method=RequestMethod.GET, value="/customers")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }
    @RequestMapping(method= RequestMethod.GET, value="/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value="/customers")
    public String addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return "Done";
    }
    @RequestMapping(method=RequestMethod.PUT, value="//customers/{id}")
    public void upDateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }





}
