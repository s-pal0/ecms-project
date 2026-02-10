package com.example.ecms.service;

import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.example.ecms.dto.CustomerCreateDTO;
import com.example.ecms.dto.CustomerUpdateDTO;
import com.example.ecms.entity.CustomerEntity;
import com.example.ecms.exception.ResourceNotFoundException;
import com.example.ecms.repository.CustomerRepository;

@Service
public class CustomerService {

    private static  final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity addCustomer(CustomerCreateDTO customerCreateDTO) {
        log.info("Adding customer: {} ", customerCreateDTO.getCustName());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustName(customerCreateDTO.getCustName());
        customerEntity.setCustAddress(customerCreateDTO.getCustAddress());
        customerEntity.setCustAge(customerCreateDTO.getCustAge());
        customerEntity.setCustEmail(customerCreateDTO.getCustEmail());

    return customerRepository.save(customerEntity);
    }

    public List<CustomerEntity> getCustomerList() {
        log.info("Showing list of customers ");
        return customerRepository.findAll();
    }

    public CustomerEntity findCustomerById(Long custId) {
        return customerRepository.findById(custId).orElseThrow(() -> new ResourceNotFoundException("Customer not found with Id - " + custId));
    }

    public CustomerEntity updateCustomer(
            Long custId,
            CustomerUpdateDTO customerUpdateDTO
    ) {
        log.info("Updating customer: {} ", customerUpdateDTO.getCustName());

        CustomerEntity  customerEntity = findCustomerById(custId);

        customerEntity.setCustName(customerUpdateDTO.getCustName());
        customerEntity.setCustAddress(customerUpdateDTO.getCustAddress());
        customerEntity.setCustAge(customerUpdateDTO.getCustAge());
        customerEntity.setCustEmail(customerUpdateDTO.getCustEmail());

        return  customerRepository.save(customerEntity);
    }

    public CustomerEntity partialUpdateCustomer(
            Long custId,
            CustomerUpdateDTO customerUpdateDTO
    ) {
        log.info("Patching customer: {} ", customerUpdateDTO.getCustName());

        CustomerEntity customerEntity = findCustomerById(custId);

        if(customerUpdateDTO.getCustName() != null) {
            customerEntity.setCustName(customerUpdateDTO.getCustName());
        }

        if(customerUpdateDTO.getCustAddress() != null) {
            customerEntity.setCustAddress(customerUpdateDTO.getCustAddress());
        }

        if(customerUpdateDTO.getCustAge() != null) {
            customerEntity.setCustAge(customerUpdateDTO.getCustAge());
        }

        if(customerUpdateDTO.getCustEmail() != null) {
            customerEntity.setCustEmail(customerUpdateDTO.getCustEmail());
        }

        return customerRepository.save(customerEntity);
    }

    public void delete(Long custId) {
        log.info("Deleting customer !");

        if(!customerRepository.existsById(custId)) {
            throw new ResourceNotFoundException("Customer not found with Id - " +custId);
        }
        customerRepository.deleteById(custId);
    }
}
