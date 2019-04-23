package jdk8;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by Administrator on 2017/3/31.
 */
public class TTT {

    public static final String REGEX_MOBILE_EXACT =
        "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(REGEX_MOBILE_EXACT);
        Matcher matcher = pattern.matcher("16987878890");
        System.out.println(matcher.matches());

    }

    private static boolean isPre(int num) {
        int mid = ( int ) Math.sqrt(num);
       return  IntStream.rangeClosed(2, mid).noneMatch(i -> num % i == 0);

    }

}
