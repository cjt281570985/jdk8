package com.cjt.jdk8.stream2;

/**
 * Created by Administrator on 2017/4/1.
 */
public class AutoCloseableTest implements  AutoCloseable{


    @Override
    public void close() throws Exception {
        System.out.println("close invoke!");
    }

    public void doSomething() throws Exception {
        System.out.println("doSomething invoke!");
    }

    public static void main(String[] args) throws Exception {

        try(AutoCloseableTest test = new AutoCloseableTest()){
            test.doSomething();
        }


    }


}
