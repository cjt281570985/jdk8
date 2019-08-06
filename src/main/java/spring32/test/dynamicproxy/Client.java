package spring32.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-05-01 16:25
 */
public class Client {

  public static void main(String[] args) {

    RealSubject realSubject = new RealSubject();

    InvocationHandler handler = new DynamicSubject(realSubject);

    Class<?> handlerClass = handler.getClass();

    Subject subject = (Subject) Proxy.newProxyInstance(
        handlerClass.getClassLoader(), realSubject.getClass().getInterfaces(), handler);

    subject.request();

    System.out.println(subject.getClass());

  }

}
