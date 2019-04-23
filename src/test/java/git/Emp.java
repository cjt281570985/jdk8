package git;

import com.google.common.collect.Lists;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-10-09 11:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

  private List<String> ids = Arrays.asList("1","2","3");

  private List<String> names = Arrays.asList("fff","das2","332a");


  public static List<String> getListFields() {

    List<String> list = Lists.newArrayList();
    try {
      Class clazz = Class.forName("git.Emp");
      //根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
      Field[] fields = clazz.getDeclaredFields();//根据Class对象获得属性 私有的也可以获得
      for(Field f : fields) {
        if (f.getType().equals(List.class)) {
          list.add(f.getName());
        }
      }
      return list;
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static List<String> getFieldValueByFieldName(String fieldName, Object object) {
    try {
      Field field = object.getClass().getDeclaredField(fieldName);
      //设置对象的访问权限，保证对private的属性的访问
      //field.setAccessible(true);
      return   (List)field.get(object);
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }


}
