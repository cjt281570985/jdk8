package basic;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-18 07:21
 */
public class ParamTest {

    public void changeInt(int a) {
        a = 3;
    }

    public static void main(String[] args) {
        int a = 1;
        ParamTest p = new ParamTest();

        p.changeInt(a);
        System.out.println(a);
    }


}
