package jdk8.optional.ten;

import java.util.Optional;

/**
 * Created by Administrator on 2017/5/23.
 */
public class Test {

    public static String getCarInsuranceName(Optional<Person> person) {

        String name = person.flatMap(Person::getCar)
                            .flatMap(Car::getInsurance)
                            .map(Insurance::getName).orElse("default java9");


        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }


    public static void main(String[] args) {

        Insurance insurance = new Insurance(null);
        Car car = new Car(Optional.of(insurance));
        Person p = new Person(Optional.of(car));

        System.out.println(Test.getCarInsuranceName(Optional.of(p)));

    }


}
