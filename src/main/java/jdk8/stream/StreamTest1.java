package jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest1 {

    public static void main(String[] args) {
        //stream 的各种定义形式
        Stream stream1 = Stream.of("cjt","abc","lhq");

        String[] arr = {"aaa", "bbb", "ccc"};
        List list = Arrays.asList(arr);

        Stream stream2 = Stream.of(arr);
        Stream stream3 = list.stream();

    }
}
