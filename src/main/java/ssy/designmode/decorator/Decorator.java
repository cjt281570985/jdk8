package ssy.designmode.decorator;

/**
 * @Author: chenjt
 * @Description: 装饰角色
 * @Date: Created 2019-04-23 1:45
 */
public class Decorator implements Component {

  private Component component;

  public Decorator(Component component) {
    this.component = component;
  }

  @Override
  public void doString() {
    component.doString();
  }
}
