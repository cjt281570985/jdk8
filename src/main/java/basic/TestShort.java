package basic;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-11 13:47
 */
public class TestShort {

    public static void main(String[] args) {
        test1();
        test2();
    }


    public static void test1() {
        short s = 1;
        s += 1;
        System.out.println(s);
    }



    public static void test2() {
        short s = 1;
        //s = s + 1;  编译通不过, 不能将右边 int 转成short
        s = (short) (s+1);
        System.out.println(s);
    }
}
