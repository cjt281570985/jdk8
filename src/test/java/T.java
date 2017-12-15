import java.util.HashMap;
import java.util.Map;

public class T {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<10; i++){
            //putIfAbsent使得我们不用写是否为null值的检测语句；
            map.putIfAbsent(i, "val_"+i);
        }

        //-------1------maps不支持流。然而现在maps包括了许多新的非常有用的方法用于执行通用任务:
        //forEach使用consumer来对map中的每个元素进行操作,执行通用任务。
        map.forEach((key, val)-> System.out.println(key+" = " +val));

        map.computeIfPresent(2, (k, v) -> v + k * 2);
        map.computeIfPresent(9, (k, v) -> null);
        System.out.println(map.get(2));
        System.out.println(map.get(9));

        map.merge(5, "val1", (oldVal, newVal) -> oldVal + "--" + newVal);
        System.out.println(map.get(5));


    }




}
