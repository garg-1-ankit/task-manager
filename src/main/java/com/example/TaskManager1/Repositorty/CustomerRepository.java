package com.example.TaskManager1.Repository;

import com.example.TaskManager1.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
