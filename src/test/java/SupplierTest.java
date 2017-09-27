import java.util.function.Supplier;

public class SupplierTest {

    public String msg = "cjt";

    public SupplierTest (){
        this.msg = "332";
    }

    public static void main(String[] args) {

        Supplier<String> stringSupplier = () -> "abc";
        System.out.println(stringSupplier.get());

        Supplier<SupplierTest> supplier = SupplierTest::new;
        System.out.println(supplier.get().msg);


    }
}
