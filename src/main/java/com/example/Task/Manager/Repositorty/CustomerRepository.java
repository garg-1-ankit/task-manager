package com.example.Task.Manager.Repositorty;

import com.example.Task.Manager.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
