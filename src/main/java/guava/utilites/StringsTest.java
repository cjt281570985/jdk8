package guava.utilites;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.primitives.Chars;

public class StringsTest {

    public static void main(String[] args) {

        String str = "";
        System.out.println(Strings.emptyToNull(str)); //null
        System.out.println(Strings.isNullOrEmpty(str));//true
        //commonPrefix  公共前缀
        System.out.println(Strings.commonPrefix("chenjt","chenlif"));//chen
        System.out.println(Strings.commonPrefix("chenjt","achenlif"));//""
        System.out.println(Strings.commonSuffix("chenjt","abcjt"));//jt
        System.out.println(Strings.repeat("cjt",2));//cjtcjt
        //没达到指定长度,前面补上指定的'X'
        System.out.println(Strings.padStart("Alex",3,'H'));//Alex
        System.out.println(Strings.padStart("Alex",6,'H'));//HHAlex

        System.out.println(Strings.padEnd("Alex",3,'H'));//Alex
        System.out.println(Strings.padEnd("Alex",6,'H'));//AlexHH
        System.out.println("-----------------------");
        //Charsets.UTF_8
        System.out.println(CharMatcher.javaDigit().matches('5')); //true
        System.out.println(CharMatcher.inRange('0','9').matches('5')); //true
        System.out.println(CharMatcher.javaDigit().matches('a')); //false
        System.out.println(CharMatcher.is('c').countIn("chencjtabc")); //统计c出现的次数 3
        System.out.println(CharMatcher.breakingWhitespace().collapseFrom(" hello world  ", '*'));//*hello*world*

        //移除数字和空格
        System.out.println(CharMatcher.javaDigit().or(CharMatcher.whitespace()).removeFrom("hello 1234 world"));//helloworld
        System.out.println(CharMatcher.inRange('0','9').or(CharMatcher.whitespace()).removeFrom("hello 1234 world"));//helloworld 移除
        //保留数字和空格
        System.out.println(CharMatcher.inRange('0','9').or(CharMatcher.whitespace()).retainFrom("hello 1234 world"));//" 1234 " 保留

    }
}
