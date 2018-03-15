import com.google.common.collect.Lists;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T2 {

    public static void main(String[] args) throws InterruptedException {

        Student s1 = new Student(1, "cjt", new BigDecimal(21000));
        Student s2 = new Student(3, "yzy", new BigDecimal(92000));
        Student s3 = new Student(5, "lhq", new BigDecimal(30000));
        Student s4 = new Student(7, "ttt", new BigDecimal(55000));

        ArrayList<Student> list = Lists.<Student>newArrayList();

        ArrayList<Student> students = Lists.newArrayList(s1, s2, s3, s4);
        students.forEach(System.out::println);

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            int count = student.getScore().divide(new BigDecimal(20000)).intValue();
            for (int j = 0; j < count; j++) {
                Student stu = new Student(student.getId(), student.getName(), student.getScore(), count > 1 ? student.getScore().toString() + "_" + (j + 1) : student.getScore().toString());
                list.add(stu);
            }

        }

        System.out.println(new BigDecimal(5000).divide(new BigDecimal(20000)).intValue());


        list.forEach(System.out::println);
        System.out.println("--------------------------------");
        List<List<Student>> partition = Lists.partition(list, 3);
        partition.forEach(System.out::println);


        System.out.println(partition.size());//当前第X期
        System.out.println(partition.get(partition.size() - 1).size());//当期如果未达到3则该期未能开奖

        System.out.println("--------------------------------");
        //studentList.stream().collect(Collectors.groupingBy(Student::getAge));

        Map<Integer, Long> map = partition.get(1).stream().collect(Collectors.groupingBy(Student::getId, Collectors.counting()));
        System.out.println(map);

    }

}
