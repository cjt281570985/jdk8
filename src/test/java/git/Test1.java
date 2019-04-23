package git;

import java.util.Arrays;
import java.util.List;
import javax.naming.Name;
import jdk8.stream3.Student;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-05-11 10:29
 */
public class Test1 {
  public static void main(String[] args) {


    List<String> listFields = Emp.getListFields();

    System.out.println(listFields);
    Emp emp = new Emp();

    System.out.println(emp.getIds());
    System.out.println(emp.getNames());

    System.out.println("--------------------------------");


    for (String field : listFields) {
      System.out.println(Emp.getFieldValueByFieldName(field, emp));
    }



  }
}
