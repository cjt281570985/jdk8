import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.util.ObjectUtils;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-07-31 13:27
 */
public class Temp {



  public static void main(String[] args) {
    List<CountDTO> list = Arrays.asList(
        new CountDTO("cjt", 5),
        new CountDTO("at", 5),
        new CountDTO("at", 15),
        new CountDTO("bbb", 52),
        new CountDTO("cjt", 12));

//    Map<String, Long> map = list.stream().collect(Collectors
//        .groupingBy(CountDTO::getName, Collectors.summingLong(CountDTO::getSum)));
//
//    System.out.println(map);

    List<CountDTO> list1 = list.subList(0, 2);
    System.out.println(list);
    System.out.println(list1);
  }

}
