package basic;


/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-27 10:31
 */
public class ThreadTest {

    public static void main(String[] args) {

        C c = new C();
        Thread t1 = new T1(c);
        Thread t2 = new T2(c);

        t1.start();
        t2.start();

    }
}

//java中一个字符能否表示一个汉字?
//在java中,一个字符表示16位,相当于2个字节(1 byte = 8 bit)

//对于当前一个对象的所有 synchronized 方法, 只能有一个对象来访问它

class C {
    public synchronized void hello() {
        try {
            Thread.sleep(3000);
            System.out.println("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void world() {
        System.out.println("world");
    }
}

class T1 extends Thread {
    private C c;

    public T1(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.hello();
    }
}

class T2 extends Thread {
    private C c;

    public T2(C c) {
        this.c = c;
    }
    @Override
    public void run() {
        c.world();
    }
}