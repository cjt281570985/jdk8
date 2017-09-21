package com.cjt.jdk8.optional.ten;

import java.util.*;

public class Person {

    public Person(Optional<Car> car) {
        this.car = car;
    }

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}
