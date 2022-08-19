package com.example.Task.Manager.Controller;

import com.example.Task.Manager.Dto.RequestDto;
import com.example.Task.Manager.Dto.ResponseDto;
import com.example.Task.Manager.Routes;
import com.example.Task.Manager.Service.CustomerService;
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
    public ResponseDto getAllCustomers() {
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


    @GetMapping(Routes.CUSTOMER_ACTIVE)
    public ResponseDto getActiveTask(){
        return customerService.getactiveCustomer();
    }

    @PostMapping(Routes.CUSTOMER_DETAILS_ID)
    public ResponseDto findMultipleTask(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.findMultipleCustomer(customerRequestDto);
    }

    @GetMapping(Routes.CUSTOMER_TOGGLE_ID)
    public ResponseDto toggleCustomerById(@PathVariable Long Id){
        return customerService.toggleCustomerById(Id);
    }

}

