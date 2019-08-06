package spring32.test.proxy;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-05-01 16:19
 */
public class RealSubject extends Subject {

  //真实角色
  @Override
  public void request() {
    System.out.println("From real subject");
  }
}
