package guava.collections;

import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FluentIterableExample {

    private FluentIterable<String> build(){
        ArrayList<String> list = Lists.newArrayList("Alex", "Wang", "Guava", "Scala");
        return FluentIterable.from(list);
    }


    @Test
    public void test() {
        List<String> appendList = Arrays.asList("Append");
        FluentIterable<String> fit = build();
        System.out.println(fit.filter(a->a.length()>4).size());

        FluentIterable<String> appends = fit.append(appendList);
        System.out.println(appends.filter(a->a.length()>4).size());
        System.out.println(appends.allMatch(e->e.length()>3));
        System.out.println(appends.first().get());
        System.out.println(appends.last().get());
        System.out.println(appends.limit(2).last());

    }

    /**
     * DSL
     */
    @Test
    public void copyIntoAndTransform() {
        ArrayList<String> copyInto = Lists.newArrayList("CopyInto");
        FluentIterable<String> fit = build();

        List<String> list1 = fit.copyInto(copyInto);
        System.out.println(list1);//[CopyInto, Alex, Wang, Guava, Scala]

        fit.transform(e->e.length()).forEach(System.out::println);
    }

    @Test
    public void cycleTest() {
        FluentIterable<String> fit = build();
        FluentIterable<String> cycle = fit.cycle().limit(8);
        System.out.println(cycle);//[Alex, Wang, Guava, Scala] (cycled)
        cycle.forEach(System.out::println); //不断循环
    }

    @Test
    public void trandfromAndConcat() {
        FluentIterable<String> fit = build();
        List<Integer> integers = Lists.newArrayList(1);

        //将多个集合合并成1个集合
        FluentIterable<Integer> result = fit.transformAndConcat(e -> integers);
        System.out.println(result);//[1, 1, 1, 1]
        result.forEach(System.out::println);
    }

    @Test
    public void join() {
        FluentIterable<String> fit = build();
        String strings = fit.join(Joiner.on("-"));
        System.out.println(strings); //Alex-Wang-Guava-Scala
    }

    @Test
    public void trandfromAndConcatInAction() {
        ArrayList<Integer> cTypes = Lists.newArrayList(1, 2);
        FluentIterable<Customer> customers = FluentIterable.from(cTypes).transformAndConcat(this::search);
        customers.forEach(System.out::println);

    }

    private List<Customer> search(int type) {
        if (type == 1) {
            return Lists.newArrayList(new Customer(type, "Alex"), new Customer(type, "Cjt"));
        }else {
            return Lists.newArrayList(new Customer(type, "Jimmy"), new Customer(type, "kkk"),new Customer(type, "ttt"));
        }
    }

    class Customer{
        final int type;
        final String name;

        public Customer(int type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "type=" + type +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
