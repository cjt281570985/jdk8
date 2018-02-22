package guava.collections;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

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
        table.put("Database", "Mysql", "7.0");

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

}
