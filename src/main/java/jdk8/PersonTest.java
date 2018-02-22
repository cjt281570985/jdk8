package jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/1/6.
 */
public class PersonTest {

    public static void main(String[] args) {
        Person person1 = new Person("cjt", 25);
        Person person2 = new Person("yzy", 22);
        Person person3 = new Person("lhq", 28);

        List<Person> personList = Arrays.asList(person1, person2, person3);
        //List<Person> rsList = PersonTest.getSPerson(26,personList);
       // List<Person> rsList = PersonTest.getSPersonByAge(28,personList);
        List<Person> rsList = PersonTest.getSPersonByAgeBiFunction(23,personList, (ageParam, listParam)->{
            return listParam.stream().filter(person -> person.getAge()>ageParam).collect(Collectors.toList());
        });

        List<Person> rsList2 = PersonTest.getSPersonByAgeBiFunction(26,personList, (ageParam, listParam)->{
            return listParam.stream().filter(person -> person.getAge()>ageParam).collect(Collectors.toList());
        });

        rsList.forEach(person -> System.out.println(person.getUsername()));
        System.out.println("--------------");
        rsList2.forEach(person -> System.out.println(person.getUsername()));
    }

    public static List<Person> getSPerson(int age, List<Person> list){
        return list.stream().filter(person -> person.getAge()>age).collect(Collectors.toList());
    }

    public static List<Person> getSPersonByAge(int age, List<Person> list){
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageParam, listParam) -> list.stream().filter(person -> person.getAge()>age).collect(Collectors.toList());
        return biFunction.apply(age, list);
    }

    public static List<Person> getSPersonByAgeBiFunction(int age, List<Person> list, BiFunction<Integer, List<Person>, List<Person>> biFunction){
        return biFunction.apply(age, list);
    }

}
