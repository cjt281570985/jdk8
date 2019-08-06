package spring32.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-05-01 17:36
 */
public class DynamicSubject implements InvocationHandler {

  private Object realSubject;

  public DynamicSubject(Object obj) {
    this.realSubject = obj;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    System.out.println("执行前...: " + method);

    method.invoke(realSubject, args);

    System.out.println(args == null);

    System.out.println("执行后...: " + method);

    return null;
  }
}
