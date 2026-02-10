package com.example.ecms.controller;

import com.example.ecms.dto.CustomerCreateDTO;
import com.example.ecms.dto.CustomerUpdateDTO;
import com.example.ecms.entity.CustomerEntity;
import com.example.ecms.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    Add Customer
    @PostMapping("/add")
    public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerCreateDTO customerCreateDTO) {
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(customerService.addCustomer(customerCreateDTO));
    }

//    Get Customers
    @GetMapping("/list")
    public List<CustomerEntity> getCustomers() {
        return  customerService.getCustomerList();
    }

    @GetMapping("/{cId}")
    public CustomerEntity getCustomer(@PathVariable("cId") Long custId) {

        return customerService.findCustomerById(custId);
    }

    @PutMapping("/update/{cId}")
    public CustomerEntity update(
            @PathVariable("cId") Long custId,
            @RequestBody CustomerUpdateDTO customerUpdateDTO
            ) {
        return customerService.updateCustomer(custId, customerUpdateDTO);
    }

    @PatchMapping("/pupdate/{cId}")
    public CustomerEntity partialUpdate(
            @PathVariable("cId") Long custId,
            @RequestBody CustomerUpdateDTO customerUpdateDTO
    ) {
        return customerService.partialUpdateCustomer(custId, customerUpdateDTO);
    }

    @DeleteMapping("/delete/{cId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("cId") Long custId) {
        customerService.delete(custId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/message")
    public String GetMessage() {
        return "Welcome to ECMS";
    }
}
