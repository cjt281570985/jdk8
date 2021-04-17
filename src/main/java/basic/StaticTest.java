package basic;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-21 10:05
 */
public class StaticTest {

    private static StaticTest st = new StaticTest();

    public static int count1 = 0;
    public static int count2 ;

    private StaticTest() {
        System.out.println("private StaticTest()...");
        count1++;
        count2++;
    }

    private StaticTest(String name) {
        System.out.println("private new new");
        count1++;
        count2++;
    }

    public static StaticTest getInstance() {
        return st;
    }

    static {
        System.out.println("count1-->: " + count1);
        System.out.println("count2-->: " + count2);
        System.out.println("static...");
    }

    public static void main(String[] args) {
        StaticTest st = StaticTest.getInstance();
        //StaticTest st = new StaticTest("name");
        System.out.println("count1: " + st.count1);
        System.out.println("count2: " + st.count2);
    }

}
