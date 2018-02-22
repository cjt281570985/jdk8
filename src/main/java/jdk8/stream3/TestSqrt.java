package jdk8.stream3;


import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/2/9.
 */
public class TestSqrt {
    public static void main(String[] args) throws Exception {

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 30).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 30)
                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0).boxed()
                                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));



    }
}