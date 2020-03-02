import com.google.common.base.CharMatcher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import lombok.Data;

public class T {

    public static void main(String[] args) {

        String string = "hello-world-java";
        String str = "";

        System.out.println(Strings.isNullOrEmpty(string));
        System.out.println(Strings.isNullOrEmpty(str));
        System.out.println(Strings.commonSuffix("cjt001a", "cj990001"));
        System.out.println(Strings.repeat("19",3));

        System.out.println(Strings.padEnd("cjt",5, '0'));
        System.out.println(Strings.padStart("cjt",3, '0'));

        System.out.println("-----------------------");

        System.out.println(CharMatcher.inRange('0','9').matches('a'));
        System.out.println(CharMatcher.inRange('0','9').matches('3'));

        System.out.println("------33-----------------");
        Student2 student = new Student2();
        student.setId(99);
        System.out.println(MoreObjects.toStringHelper(student).addValue(3).add("k","v"));;

    }



    @Data
    public static class Student2 {

        private int id;
        private String name;

    }
}
