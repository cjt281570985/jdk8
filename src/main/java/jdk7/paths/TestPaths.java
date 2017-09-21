package jdk7.paths;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**
 * Created by Administrator on 2017/5/10.
 */
public class TestPaths {


    public static void main(String[] args) {

        //testDir();
        System.out.println(Arrays.asList(22,2,13,6,33,8,3,67,21).stream().reduce(Integer::min));;
        List<Integer> collect = Arrays.asList(22, 2, 13, 6, 33, 8, 3, 67, 21).stream().collect(toList());

        String[] arr = {"cjt", "yzy"};
        Stream<String> stringStream = Arrays.stream(arr).map(a -> a.split("")).flatMap(Arrays::stream);
        stringStream.forEach(System.out::println);

    }


    public static void testDir(){
        Path dir = Paths.get("D:\\workspace_Intellij\\jdk8\\src\\main\\java\\com\\cjt\\jdk8");
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir)) {
            directoryStream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void testPath1(){
        Path path = Paths.get("D:\\workspace_Intellij\\jdk8\\src\\main\\java\\jdk7\\paths\\TestPaths.java");
        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
