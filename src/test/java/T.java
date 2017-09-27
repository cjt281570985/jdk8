import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.BinaryOperator;

public class T {

    public static void main(String[] args) {


        System.out.println("15985857788".replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1****$2"));

        System.out.println("abac".replace("a", "\\a")); //\ab\ac
        System.out.println("abac".replaceAll("a", "\\a")); //abac
        System.out.println("abac".replaceFirst("a", "\\a")); //abac

    }


}
