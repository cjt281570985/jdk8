package ssy.dynamic;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2022-12-08 下午2:07
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("RealSubject....request....");
    }
}
