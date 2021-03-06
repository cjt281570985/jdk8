package concurrency.first.chapter3;

public class CreateThread4 {

    private int i = 0;

    private byte[] bytes = new byte[1024];

    private static int count = 0;


    public static void main(String[] args) {
        System.out.println(1<<2);
        System.out.println(1<<3);
        System.out.println(1<<4);
        System.out.println(1<<5);
        Thread t1 = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(0);
                } catch (Error e) {
                    e.printStackTrace();
                    System.out.println("count: " + count);
                }
            }

            private void add(int i) {
                if (i + 10 > 297274) {
                   return;
                }
                ++count;
                add(i + 1);
            }
        },"jimmy", 1<<24);

        t1.start();
    }

}
