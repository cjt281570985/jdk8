package concurrency.first.chapter6;

public class Test {

  public static void main(String[] args) throws Exception {

    Thread t1 = new Thread(){
      @Override
      public void run() {
        while (true) {
          System.out.println(">>>>>" + this.isInterrupted());
        }
      }
    };

    t1.start();
    System.out.println(t1.isInterrupted());
    t1.interrupt();
    System.out.println(t1.isInterrupted());

  }
}