import java.util.ArrayList;
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
        new CountDTO("cjt", 6),
        new CountDTO("at", 5),
        new CountDTO("bbb", 52),
        new CountDTO("ata", 6),
        new CountDTO("cjt", 5));

    List<CountDTO> collect = list.stream().map(d -> {
      d.setName("吉米" + d.getName());
      return d;
    }).collect(Collectors.toList());
    System.out.println(collect);

//    Map<String, Long> map = list.stream().collect(Collectors
//        .groupingBy(CountDTO::getName, Collectors.summingLong(CountDTO::getSum)));
//
//    System.out.println(map);
//    Map<String, Integer> collect = list.stream().collect(Collectors.toMap(dto->dto.getName()+"-"+dto.getSum(), CountDTO::getSum));
//    System.out.println(collect);


//    System.out.println("--------------------------------");
//    List<CountDTO> list1 = list.subList(0, 2);
//    System.out.println(list);
//    System.out.println(list1);
  List<CountDTO> list2 = new ArrayList<>(list);
//    System.out.println(list);
//    System.out.println("--------------------------------");
//    System.out.println(list2);
//    System.out.println("--------------------------------");
//
    for (int i = 0; i < list.size()-2; i++) {
      for (int j = i+1; j < list2.size(); j++) {
        if (list.get(i).getSum() == list2.get(j).getSum()) {
          System.out.println("有重复的");
          System.out.println(list2.get(j));
          break;
        }
      }
    }


  }

}
