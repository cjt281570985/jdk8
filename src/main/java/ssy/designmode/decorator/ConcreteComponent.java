package ssy.designmode.decorator;

/**
 * @Author: chenjt
 * @Description: 具体构建角色
 * @Date: Created 2019-04-23 1:42
 */
public class ConcreteComponent implements Component {

  @Override
  public void doString() {
    System.out.println("功能A");
  }
}
