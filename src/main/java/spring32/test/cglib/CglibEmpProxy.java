package spring32.test.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-05-02 14:35
 */
public class CglibEmpProxy implements MethodInterceptor {

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

    CglibEmpProxy cglibEmpProxy = new CglibEmpProxy();
    Employee employee = (Employee)cglibEmpProxy.getProxy(Employee.class);

    //spring32.test.cglib.Employee$$EnhancerByCGLIB$$89fe922c
    System.out.println("employee class name: " + employee.getClass().getName());

    //spring32.test.cglib.Employee
    System.out.println("employee Superclass name: " + employee.getClass().getSuperclass().getName());

    employee.work();
  }

}
