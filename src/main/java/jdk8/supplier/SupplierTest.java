package jdk8.supplier;

import java.util.function.Supplier;

/**
 * Created by Administrator on 2017/1/15.
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier = ()-> {return "hello";};
        Supplier<String> supplier2 = ()-> "world";

        System.out.println(supplier.get());
        System.out.println(supplier2.get());
    }
}
