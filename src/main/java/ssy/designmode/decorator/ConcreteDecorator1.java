package ssy.designmode.decorator;

/**
 * @Author: chenjt
 * @Description: 具体构建角色1
 * @Date: Created 2019-04-23 1:48
 */
public class ConcreteDecorator1 extends Decorator {

  public ConcreteDecorator1(Component component) {
    super(component);
  }

  @Override
  public void doString() {
    super.doString();

    doAnother();
  }

  private void doAnother() {
    System.out.println("功能B");
  }
}
