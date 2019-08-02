package com.fileservice.features.salesman.model;

import java.math.BigDecimal;

public class SalesmanModel {

    private String cpf;
    private String name;
    private Double salary;
    private Double totalSold;

    public SalesmanModel() {
    }

    public SalesmanModel(String cpf, String name, Double salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
