package com.example.TaskManager1.Controller;

import com.example.TaskManager1.Dto.RequestDto;
import com.example.TaskManager1.Dto.ResponseDto;
import com.example.TaskManager1.Entity.Customer;
import com.example.TaskManager1.Routes;
import com.example.TaskManager1.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController{

    @Autowired
    private CustomerService customerService;


    @GetMapping(Routes.INITIAL)
    public String hello(){
        return "Hello";
    }

    @RequestMapping(Routes.CUSTOMER_BASE)
    public List<ResponseDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(Routes.CUSTOMER_VALUE)
    public ResponseDto getCustomerById(@PathVariable Long Id) {
        return customerService.getCustomerById(Id);
    }

    @RequestMapping(method = RequestMethod.POST, value = Routes.CUSTOMER_BASE)
    public void addCustomers(@RequestBody RequestDto requestDto) {
        customerService.addCustomer(requestDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = Routes.CUSTOMER_VALUE)
    public void updateCustomers(@RequestBody RequestDto requestDto, @PathVariable Long Id) {
        customerService.updateCustomer(Id, requestDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = Routes.CUSTOMER_VALUE)
    public void deleteCustomers(@PathVariable Long Id) {
        customerService.deleteCustomer(Id);
    }
}

