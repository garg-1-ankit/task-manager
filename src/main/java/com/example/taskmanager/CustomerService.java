package com.example.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> getAllCustomers() {
    List<Customer> customers = new ArrayList<>();
    customerRepository.findAll().forEach(customers::add);
    return customers;
  }

  public void addCustomer(Customer customer) {
    customerRepository.save(customer);
  }

  public void updateCustomer(long Id, Customer customer) {
    customerRepository.save(customer);
  }

  public void deleteCustomer(long Id) {
    customerRepository.deleteById(Id);
  }
}
