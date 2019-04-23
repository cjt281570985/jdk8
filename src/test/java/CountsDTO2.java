import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zli on 2018/9/10.
 *
 * 统计
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountsDTO2 implements Serializable {

  private static final long serialVersionUID = 1423462917225056209L;

  private String uid;

  private String gid;

  private Integer sucess;

  private Integer fail;

  private Integer start;

  public String getKey() {
    return this.uid.concat(this.gid);
  }

  public static void main(String[] args) {

    CountsDTO2 c1 = new CountsDTO2("11", "21", 5, null, 0);
    CountsDTO2 c2 = new CountsDTO2("12", "22", 10, 2, null);
    CountsDTO2 c3 = new CountsDTO2("13", "21", 3, 7, 2);

    CountsDTO2 c4 = new CountsDTO2("11", "21", 0, 0, 2);
    CountsDTO2 c5 = new CountsDTO2("12", "21", 0, 0, 8);
    CountsDTO2 c6 = new CountsDTO2("13", "21", 2, null, 3);

    List<CountsDTO2> list = Arrays.asList(c1, c2, c3);
    List<CountsDTO2> list2 = Arrays.asList(c4, c5, c6);

    list.addAll(list2);

    list.stream().collect(Collectors.toList());



  }

}
