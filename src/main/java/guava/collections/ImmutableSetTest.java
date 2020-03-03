package guava.collections;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2020-03-03 23:11
 **/
public class ImmutableSetTest {

  @Test
  public void test() {
    //除了已排序的集合之外，构建时还保留顺序
    ImmutableSet set = ImmutableSet.of("b", "a", "v","c","y", "c");
    System.out.println(set);

  }

}
