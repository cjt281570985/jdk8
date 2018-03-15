import lombok.Data;

import java.math.BigDecimal;

@Data
public class Student {

    private int id;
    private String name;
    private String moneyTimes;
    private BigDecimal score;

    public Student(int id, String name, BigDecimal score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public Student(int id, String name, BigDecimal score, String moneyTimes) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.moneyTimes = moneyTimes;
    }
}
