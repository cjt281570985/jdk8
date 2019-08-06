package spring32.test.proxy;

import java.util.Objects;

/**
 * @Author: chenjt
 * @Description: 代理角色
 * @Date: Created 2019-05-01 16:20
 */
public class ProxySubject extends Subject {

  private RealSubject realSubject;

  @Override
  public void request() {
    this.preRequest();

    if (Objects.isNull(realSubject)) {
      realSubject = new RealSubject();
    }
    realSubject.request();

    this.postRequest();
  }

  private void preRequest() {
    System.out.println("pre request ...");
  }

  private void postRequest() {
    System.out.println("post request ...");
  }

}
