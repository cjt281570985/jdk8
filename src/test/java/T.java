import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class T {

    public static void main(String[] args) {

        List<String> list2 = Arrays.asList("hello5", "world", "cjt");
        list2.stream().map(a -> {
            a = a.toUpperCase();
            System.out.println("this is map");
            return a;
        }).findFirst().ifPresent(System.out::println)
             ;

    }


}
