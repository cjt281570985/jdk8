import java.io.Serializable;
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
public class CountDTO implements Serializable {

  private static final long serialVersionUID = 1423462917225056209L;

  private String name;

  /**
   * 统计出来的值
   */
  private Integer sum;

}
