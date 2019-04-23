package ssy.designmode.decorator;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-23 1:54
 */
public class Client {

  public static void main(String[] args) {

      Component component1 = new ConcreteComponent();
      Component component2 = new ConcreteDecorator1(component1);
      Component component3 = new ConcreteDecorator2(component2);

      component3.doString();

  }

}
