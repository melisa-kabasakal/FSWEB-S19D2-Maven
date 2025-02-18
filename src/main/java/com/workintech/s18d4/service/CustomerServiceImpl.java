package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workintech.s18d4.entity.Customer;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer find(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer delete(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
            return customer.get();
        }
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
