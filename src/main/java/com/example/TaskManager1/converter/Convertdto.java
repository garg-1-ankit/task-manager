package com.example.TaskManager1.converter;

import com.example.TaskManager1.Dto.RequestDto;
import com.example.TaskManager1.Dto.ResponseDto;
import com.example.TaskManager1.Entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Convertdto {
    public ResponseDto entityToDto(Customer customer){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(customer.getId());
        responseDto.setName(customer.getName());
        responseDto.setEmail(customer.getEmail());
        responseDto.setDob(customer.getDob());
        responseDto.setPhoneNumber(customer.getPhoneNumber());
        return responseDto;
    }

    public List<ResponseDto> entityToDto(List<Customer> customer){
        return customer.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Customer dtoToEntity(RequestDto requestDto){
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
