package guava.functional;

import java.util.concurrent.TimeUnit;

public class ElapsedExample {

        public static void main(String[] args) throws InterruptedException {

            process("123");
        }

        private static void process(String orderNo) throws InterruptedException {

            System.out.printf("start process ther order %s\n", orderNo);
            long startNano = System.nanoTime();
            TimeUnit.SECONDS.sleep(1);

            System.out.printf("The orderNo %s process sucess and elapsed %d ns.\n", orderNo, (System.nanoTime()-startNano));

        }
}
