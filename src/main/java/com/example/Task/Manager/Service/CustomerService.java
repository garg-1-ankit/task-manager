package com.example.Task.Manager.Service;


import com.example.Task.Manager.Dto.MetaDTO;
import com.example.Task.Manager.Dto.RequestDto;
import com.example.Task.Manager.Dto.ResponseDto;
import com.example.Task.Manager.Entity.Customer;
import com.example.Task.Manager.Repositorty.CustomerRepository;
import com.example.Task.Manager.converter.Convertdto;
import com.example.Task.Manager.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private Convertdto convertdto;

    public ResponseDto getAllCustomers() {
        ResponseDto responseDto = new ResponseDto();
        MetaDTO metaDTO = new MetaDTO("success","200");
        responseDto.setMeta(metaDTO);
        List<Customer> findAll = customerRepository.findAll();
        responseDto.setData(findAll
                .stream().collect(Collectors.toList()).toString());
        return responseDto;
    }

    public ResponseDto getCustomerById(Long Id){
        if(Id != null) {
            ResponseDto responseDto = new ResponseDto();
            Customer existCustomer = this.customerRepository.findById(Id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + Id));
            responseDto.setData(existCustomer.toString());
            MetaDTO metaDTO = new MetaDTO("success", "200");
            responseDto.setMeta(metaDTO);
            return responseDto;
        }else throw new ResourceNotFoundException("Please enter correct Id");
    }


    public void addCustomer(RequestDto requestDto) {
        customerRepository.save(convertdto.dtoToEntity(requestDto));
    }

    public Customer updateCustomer(Long Id, RequestDto requestDto) {
        Customer existCustomer = this.customerRepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id :" + Id));
        if(requestDto.getName() != null)
            existCustomer.setName(requestDto.getName());

        if(requestDto.getEmail() != null)
        existCustomer.setEmail(requestDto.getEmail());

        if(requestDto.getDob() != null)
        existCustomer.setDob(requestDto.getDob());

        if(requestDto.getPhoneNumber() != null)
        existCustomer.setPhoneNumber(requestDto.getPhoneNumber());

        return customerRepository.save(existCustomer);

    }

    public ResponseEntity<Customer> deleteCustomer(Long Id) {
        if(Id!=null) {
            this.customerRepository.deleteById(Id);
            return ResponseEntity.ok().build();
        }else throw new ResourceNotFoundException("Please input correct Id");
    }
}
