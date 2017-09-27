package optional;

import java.util.Optional;
import java.util.function.Supplier;

public class T1 {


    public static void main(String[] args) {

        Optional<String> op1 = Optional.ofNullable(null);


        if (op1.isPresent()) {
            System.out.println(op1.get());
        }

        op1.ifPresent(System.out::println);

        System.out.println(op1.orElse("ttt"));
        System.out.println(op1.orElseGet(()-> "66"));


    }
}
