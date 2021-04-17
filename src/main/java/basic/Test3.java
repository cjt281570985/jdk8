package basic;

import com.bjsxt.base.coll013.Test;

import java.util.Date;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-27 11:15
 */
public class Test3 {

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        String s = test3.get(new Date());
        System.out.println(s);

        System.out.println("--------------------------------");
        String s2 = test3.get(new Date(){
            //这是一个继承日期的匿名内部类

            @Override
            @SuppressWarnings("deprecation")
            public String toLocaleString() {
                System.out.println("000");
                return super.toLocaleString();
            }
        });
        System.out.println(s2);
    }

    @SuppressWarnings("deprecation")
    public String get(Date date) {
        return date.toLocaleString();
    }

}
