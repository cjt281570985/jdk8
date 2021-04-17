package basic;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-23 20:18
 */
public class ExceptionTest {

    //Java异常分为2类:
    //1.checked exception
    //2.unchecked exception (RunTimeException)

    public void dosth() throws ArithmeticException {
        System.out.println("do sth");
    }

    public static void main(String[] args) {

        ExceptionTest test = new ExceptionTest();
        test.dosth();


    }

}
