package guava.functional;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public class FunctionExample {

    public static void main(String[] args) {

        Function<String, Integer> function = new Function<String, Integer>(){
            @Override
            public Integer apply(String input) {
                Preconditions.checkNotNull(input, "input不能为空");
                return input.length();
            }
        };

        System.out.println(function.apply("null"));

    }
}
