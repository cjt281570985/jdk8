package guava.utilites;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SplitTest {

    public static void main(String[] args) {

        String string = "hello-world-java";
        List<String> list = Splitter.on("-").limit(2).splitToList(string);//[hello, world-java]
        System.out.println(list);

        List<String> list0 = Splitter.on(Pattern.compile("\\-")).trimResults().splitToList("hello- world -java ");
        System.out.println("list0: " + list0);//list0: [hello, world, java]

        List<String> list1 = Splitter.onPattern("\\-").trimResults().splitToList("hello- world -java ");
        System.out.println("list1: " + list1);//list1: [hello, world, java]

        List<String> list2 = Splitter.on("-").splitToList(string);
        System.out.println("list2: " + list2);//list2: [hello, world, java]

        System.out.println("--------------------------------");
        String string2 = "hello-world-java---";
        List<String> list3 = Splitter.on("-").splitToList(string2);
        List<String> list4 = Splitter.on("-").omitEmptyStrings().splitToList(string2);
        System.out.println("list3: " + list3); //[hello, world, java, , , ]
        System.out.println("list4: " + list4); //[hello, world, java]

        System.out.println("--------------------------------");
        String string3 = "hello- world -java ";
        List<String> list5 = Splitter.on("-").trimResults().splitToList(string3);
        System.out.println("list5: " + list5); //[hello, world, java]

        String string4 = "aaaabbbbccccdddd";
        List<String> list6 = Splitter.fixedLength(4).splitToList(string4);
        System.out.println("list6: " + list6); //[aaaa, bbbb, cccc, dddd]

        Map<String, String> stringMap = Splitter.on(Pattern.compile("\\-")).trimResults().omitEmptyStrings()
                .withKeyValueSeparator("=").split(" age = 20 - name= cjt---");
        System.out.println("stringMap: " + stringMap); //stringMap: {age = 20, name= cjt}

    }
}
