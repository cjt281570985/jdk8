package guava.collections;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class TableTest {

    //ArrayTable
    //TreeBaseTable
    //HashBaseTable
    //ImmutableTable
    //学数据结构,看源码

    @Test
    public void test() {
        Table<String, String, String> table = HashBasedTable.create();
        table.put("Language", "Java", "1.8");
        table.put("Language", "Scala", "2.3");
        table.put("Database", "Oracle", "12C");
        table.put("Database", "Oracle", "7.0");

        System.out.println(table);//{Language={Java=1.8, Scala=2.3}, Database={Oracle=12C, Mysql=7.0}}
        Map<String, String> database = table.row("Database");
        System.out.println(database);//{Oracle=12C, Mysql=7.0}

        System.out.println(database.get("Oracle"));//12C
        System.out.println(table.column("Oracle").get("Database"));//12C

        System.out.println(table.column("Oracle"));//Map<String, String> oracle     {Database=12C}

        Set<Table.Cell<String, String, String>> cells = table.cellSet();
        //[(Language,Java)=1.8, (Language,Scala)=2.3, (Database,Oracle)=12C, (Database,Mysql)=7.0]
        System.out.println(cells);
    }
    @Test
    public void test2() {
        Table<Integer, Integer, Integer> table = HashBasedTable.create();
        table.put(1, 2, 3);
        //允许row和column确定的二维点重复
        table.put(1, 6, 3);
        //判断row和column确定的二维点是否存在
        if (table.contains(1, 2)) {
            table.put(1, 4, 4);
            table.put(2, 5, 4);
        }
        System.out.println(table);
        //获取column为5的数据集
        Map<Integer, Integer> column = table.column(5);
        System.out.println(column);
        //获取rowkey为1的数据集
        Map<Integer, Integer> row = table.row(1);
        System.out.println(row);
        //获取rowKey为1，columnKey为2的的结果
        Integer value = table.get(1, 2);
        System.out.println(value);
        //判断是否包含columnKey的值
        System.out.println(table.containsColumn(3));
        //判断是否包含rowKey为1的视图
        System.out.println(table.containsRow(1));
        //判断是否包含值为2的集合
        System.out.println(table.containsValue(2));
        //将table转换为Map套Map格式
        Map<Integer, Map<Integer, Integer>> rowMap = table.rowMap();
        System.out.println(rowMap);
        //获取所有的rowKey值的集合
        Set<Integer> keySet = table.rowKeySet();
        System.out.println(keySet);
        //删除rowKey为1，columnKey为2的元素，返回删除元素的值
        Integer res = table.remove(1, 2);
        //清空集合
        table.clear();
        System.out.println(res);
        System.out.println(table);
    }

}
