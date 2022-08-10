package com.example.Task.Manager.converter;

import com.example.Task.Manager.Dto.RequestDto;
import com.example.Task.Manager.Entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Convertdto {

    public Customer dtoToEntity(RequestDto requestDto ){
        Customer customer = new Customer();
        customer.setName(requestDto.getName());
        customer.setEmail(requestDto.getEmail());
        customer.setDob(requestDto.getDob());
        customer.setPhoneNumber(requestDto.getPhoneNumber());
        return customer;
    }

    public List<Customer> dtoToEntity(List<RequestDto> requestDto){
        return requestDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
