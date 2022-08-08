package com.example.TaskManager1.Service;


import com.example.TaskManager1.Dto.RequestDto;
import com.example.TaskManager1.Dto.ResponseDto;
import com.example.TaskManager1.Entity.Customer;
import com.example.TaskManager1.Repository.CustomerRepository;
import com.example.TaskManager1.converter.Convertdto;
import com.example.TaskManager1.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private Convertdto convertdto;

    public List<ResponseDto> getAllCustomers() {
        List<Customer> findAll = (List<Customer>) customerRepository.findAll();
        return convertdto.entityToDto(findAll);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void addCustomer(RequestDto requestDto) {
        customerRepository.save(convertdto.dtoToEntity(requestDto));
    }
    public ResponseEntity<Customer> updateCustomer(Long Id, RequestDto requestDto) {
        Customer existCustomer = this.customerRepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id :" + Id));
        this.customerRepository.save(convertdto.dtoToEntity(requestDto));
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Customer> deleteCustomer(Long Id) {
        Customer existCustomer = this.customerRepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id :" + Id));
        this.customerRepository.deleteById(Id);
        return ResponseEntity.ok().build();
    }

    public ResponseDto getCustomerById(Long Id) {
        Customer existCustomer = this.customerRepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id :" + Id));
        return convertdto.entityToDto(existCustomer);
    }
}
