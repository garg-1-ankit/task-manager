package com.example.taskmanager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerConttroller {

  @Autowired
  private CustomerService customerService;

  @GetMapping("/")
  public String hello(){
    return "Hello";
  }

  @RequestMapping("/Customer")
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/Customer")
  public void addCustomers(@RequestBody Customer customer) {
    customerService.addCustomer(customer);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/Customer/{Id}")
  public void updateCustomers(@RequestBody Customer customer, @PathVariable Long Id) {
    customerService.updateCustomer(Id, customer);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/Customer/{Id}")
  public void deleteCustomers(@PathVariable Long Id) {
    customerService.deleteCustomer(Id);
  }
}
