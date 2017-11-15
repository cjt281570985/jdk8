package stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest3 {


    public static void main(String[] args) {

        //collect
        List<String> list = Arrays.asList("hell2o", "world", "99", "99");

        list.stream().filter(s -> s.length() > 30).findFirst().ifPresent(System.out::println);

        boolean b = list.stream().allMatch(s -> s.length() > 1);
        System.out.println(b);


    }
}
