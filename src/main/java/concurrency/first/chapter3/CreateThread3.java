package concurrency.first.chapter3;

public class CreateThread3 {

    private int i = 0;

    private byte[] bytes = new byte[1024];

    private static int count = 0;


    public static void main(String[] args) {

        try {
            add(0);
        } catch (Error e) {
            e.printStackTrace();
            System.out.println("count: " + count);
        }


    }

    private static void add(int i) {
        ++count;
        add(i + 1);
    }

}
