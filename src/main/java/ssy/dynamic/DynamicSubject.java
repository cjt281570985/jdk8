package ssy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2022-12-08 下午2:08
 */
public class DynamicSubject implements InvocationHandler {

    private Object object;

    public DynamicSubject(Object obj) {
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before.............111....");

        method.invoke(object, args);

        System.out.println("after..............222...");
        return null;
    }
}
