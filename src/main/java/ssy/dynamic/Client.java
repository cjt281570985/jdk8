package ssy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2022-12-08 下午2:13
 */
public class Client {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();

        DynamicSubject dynamicSubject = new DynamicSubject(realSubject);
        Class<? extends DynamicSubject> aClass = dynamicSubject.getClass();

        Subject subject = (Subject)Proxy.newProxyInstance(aClass.getClassLoader(), realSubject.getClass().getInterfaces(), dynamicSubject);
        subject.request();

        System.out.println(realSubject.getClass().getInterfaces());
        System.out.println(subject.getClass());
    }

}
