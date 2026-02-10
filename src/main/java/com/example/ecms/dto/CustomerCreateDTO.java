package com.example.ecms.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class CustomerCreateDTO {

    @NotBlank(message = "Customer name is required")
    @Column(nullable = false)
    private String custName;

    @Column(nullable = false)
    private String custAddress;

    private String custEmail;
    private Integer custAge;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public Integer getCustAge() {
        return custAge;
    }

    public void setCustAge(Integer custAge) {
        this.custAge = custAge;
    }
}
