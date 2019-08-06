import java.util.stream.IntStream;

public class T {

    public static void main(String[] args) throws InterruptedException {

        int[] a = {69, 8, -5, 6, 3, 85};
        IntStream.of(a).min().ifPresent(System.out::println);


    }

}
