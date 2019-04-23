import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
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
public class CountsDTO implements Serializable {

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

    CountsDTO c1 = new CountsDTO("11", "21", 5, 6, 0);
    CountsDTO c2 = new CountsDTO("11", "22", 10, 2, 0);
    CountsDTO c3 = new CountsDTO("12", "21", 3, 7, 0);

    CountsDTO c4 = new CountsDTO("11", "21", 0, 0, 2);
    CountsDTO c5 = new CountsDTO("12", "21", 0, 0, 8);
    CountsDTO c6 = new CountsDTO("52", "21", 0, 0, 30);

    List<CountsDTO> list = Arrays.asList(c1, c2, c3);
    List<CountsDTO> listCopy = Arrays.asList(c1, c2, c3);
    List<CountsDTO> list2 = Arrays.asList(c4, c5, c6);

    for (CountsDTO c : list) {
      list2.forEach(cc  -> {
        if (c.getKey().equals(cc.getKey())) {
          c.setStart(cc.getStart());
        } else {
          listCopy.add(cc);
        }
      });
    }

    System.out.println(listCopy);

  }

}
