package spring32.test.proxy;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-05-01 16:25
 */
public class Client {

  public static void main(String[] args) {

    Subject subject = new ProxySubject();

    subject.request();
  }

}
