import com.google.common.base.CharMatcher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import java.util.regex.Pattern;
import lombok.Data;

public class T {

    public static final String REGEX_MOBILE_EXACT = "^1[3-9]\\d{9}$";

    public static void main(String[] args) {

        boolean matches = Pattern.matches(REGEX_MOBILE_EXACT, "13929298882");
        System.out.println(matches);

    }



    @Data
    public static class Student2 {

        private int id;
        private String name;

    }
}
