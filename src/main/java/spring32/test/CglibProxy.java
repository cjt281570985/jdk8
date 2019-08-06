package spring32.test;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-20 2:25
 */
public class CglibProxy implements MethodInterceptor {

  private Enhancer enhancer = new Enhancer();

  public Object getProxy(Class<?> clazz) {
    enhancer.setSuperclass(clazz);
    enhancer.setCallback(this);
    return enhancer.create();
  }

  @Override
  public Object intercept(Object obj, Method method, Object[] params, MethodProxy methodProxy)
      throws Throwable {

    System.out.println(obj.getClass().getName() + "." + method.getName());

    //执行对应的方法
    Object result = methodProxy.invokeSuper(obj, params);

    System.out.println("执行结束!");

    return result;
  }


  public static void main(String[] args) {

    CglibProxy cglibProxy = new CglibProxy();
    Person person = (Person)cglibProxy.getProxy(PersonImpl.class);
    System.out.println(person.getClass().getName());

    person.say();

  }
}
