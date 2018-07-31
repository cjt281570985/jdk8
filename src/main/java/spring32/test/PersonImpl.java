package spring32.test;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-07-15 14:45
 */
public class PersonImpl implements Person {

  private String name;


  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String say() {
    if (name == null) {
      return "zhang san";
    }
    return "Hello, " + name;
  }
}
