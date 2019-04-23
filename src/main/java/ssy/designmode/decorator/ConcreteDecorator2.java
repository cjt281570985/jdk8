package ssy.designmode.decorator;

/**
 * @Author: chenjt
 * @Description: 具体构建角色2
 * @Date: Created 2019-04-23 1:51
 */
public class ConcreteDecorator2 extends Decorator {

  public ConcreteDecorator2(Component component) {
    super(component);
  }

  @Override
  public void doString() {
    super.doString();
    
    doAnother();
  }

  private void doAnother() {
    System.out.println("功能C");
  }
}
