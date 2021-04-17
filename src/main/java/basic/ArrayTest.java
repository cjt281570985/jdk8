package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-27 10:31
 */
public class ArrayTest {

    public static void main(String[] args) {

        char[] ch1 = new char[2];
        ch1[0] = 'a';
        ch1[1] = 'b';

        char[] ch2 = new char[2];
        ch2[0] = 'a';
        ch2[1] = 'b';

        System.out.println(ch1.equals(ch2));
        System.out.println(Arrays.equals(ch1, ch2));

    }

}
