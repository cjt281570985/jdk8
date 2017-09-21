package com.cjt.jdk8.optional.ten;

import java.util.*;

public class Car {

    private Optional<Insurance> insurance;

    public Car(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }


}
