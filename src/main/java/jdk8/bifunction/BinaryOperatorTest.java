package jdk8.bifunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class BinaryOperatorTest {

    public static void main(String[] args) {

        Person person1 = new Person("cj8t", 25);
        Person person2 = new Person("yzy", 22);
        Person person3 = new Person("lhq", 28);

        List<Person> personList = Arrays.asList(person1, person2, person3);




    }

    //函数式编程传递的是行为而不仅仅是数据
    public static List<Person> getSPersonByAgeBiFunction(int age, List<Person> list, BiFunction<Integer, List<Person>, List<Person>> biFunction){
        return biFunction.apply(age, list);
    }


}
