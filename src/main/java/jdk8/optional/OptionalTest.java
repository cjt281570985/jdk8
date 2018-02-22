package jdk8.optional;

import java.util.Optional;

/**
 * Created by Administrator on 2017/1/15.
 */
public class OptionalTest {
    public static void main(String[] args) {
        //Optional<String> optional = Optional.of("hello");
        Optional<String> optional = Optional.ofNullable("aaa");
//        if(optional.isPresent()){
//            System.out.println(optional.get());
//        }

        optional.ifPresent(item-> System.out.println(item)); //推荐的optional使用方式
        optional.ifPresent(System.out::println); //推荐的optional使用方式
        System.out.println(optional.orElse("abc"));;//optional 中 value为空时输出 abc
        System.out.println(optional.orElseGet(()->"chenjt"));

        System.out.println("-----------------------------------");
        Optional a = Optional.empty();
        a.ifPresent(System.out::println);
        System.out.println(a.orElseGet(() -> "333"));
        Employee e = new Employee();
        e.setName("cjt000");
        System.out.println(a.orElseGet(e::getName));

    }
}
