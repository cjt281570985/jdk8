package com.cjt.jdk8.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2017/1/15.
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("cjt");
        Employee employee2 = new Employee("yzy");

        List<Employee> employees = Arrays.asList(employee1, employee2);
        Company company = new Company("company1");
        company.setEmployees(employees);

        Optional<Company> optional = Optional.ofNullable(company);
        System.out.println(optional.map(company1 -> company1.getEmployees()).orElse(Collections.emptyList()));

    }
}
