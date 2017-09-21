package com.cjt.jdk8.optional;

import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public class Company {
    private  String name;
    private List<Employee> employees ;

    public Company() {

    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
