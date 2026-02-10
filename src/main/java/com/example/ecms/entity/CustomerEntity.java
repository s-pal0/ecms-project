package com.example.ecms.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    public CustomerEntity() {
    }

    public CustomerEntity(String custName, String custAddress, String custEmail, Integer custAge) {

        this.custName = custName;
        this.custAddress = custAddress;
        this.custEmail = custEmail;
        this.custAge = custAge;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CustomerEntity that)) return false;
        return Objects.equals(custId, that.custId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(custId);
    }
}
