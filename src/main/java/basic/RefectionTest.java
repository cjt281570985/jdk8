package basic;

import java.lang.reflect.Field;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-19 07:03
 */
public class RefectionTest {

    public static void main(String[] args) throws Exception {

        PrivateTest pt = new PrivateTest();

        Class<PrivateTest> classz = PrivateTest.class;

        Field field = classz.getDeclaredField("name");
        field.setAccessible(true); //默认是false, false表示被反射的对象应该执行Java语言访问检查。

        field.set(pt, "jimmy");

        System.out.println(pt.getName()); //jimmy

    }
}
