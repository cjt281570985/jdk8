import java.util.Random;

public class T {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(20);
            CountDTO dto = new CountDTO("c" + i, num);
        }



    }

}
