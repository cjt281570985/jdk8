package guava.utilites;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JoinTest {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("java", "c++", "php", "ios");
        List<String> list2 = Arrays.asList("java", null, "php", "ios");

        String str1 = Joiner.on("-").join(list1);
        System.out.println(str1);//java-c++-php-ios

        String str2 = Joiner.on("-").skipNulls().join(list2);
        System.out.println(str2);//java-php-ios

        String str3 = Joiner.on("-").useForNull("默认").join(list2);
        System.out.println(str3); //java-默认-php-ios

        StringBuilder sb = Joiner.on("-").useForNull("默认").appendTo(new StringBuilder(), list2);
        System.out.println(sb.toString());//java-默认-php-ios

        String collect = list2.stream().filter(s -> s != null && s.length() > 0).collect(Collectors.joining("-"));
        System.out.println(collect); //java-php-ios

        final ImmutableMap<String, String> stringMap = ImmutableMap.of("java", ".net", "php", "ios");
        System.out.println(stringMap); //{java=.net, php=ios}

        String str4 = Joiner.on(",").withKeyValueSeparator("=").join(stringMap);
        System.out.println(str4); //java=.net,php=ios

        Map<String, String> map = Maps.newHashMap();
        map.put("a", "111");
        map.put("b", "222");

        //map拼接成字符串  {a=111, b=222} -> a=111,b=222
        String join = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(join);

        //字符串分割成对象 a=111,b=222  ->  {a=111, b=222}
        Map<String, String> split = Splitter.on(",").withKeyValueSeparator("=").split(join);
        System.out.println(split);

    }
}
