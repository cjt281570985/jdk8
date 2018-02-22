package guava.utilites;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Objects;

public class PreconditionsTest {

    public static void main(String[] args) {

        Objects.requireNonNull(null);
        //Preconditions.checkNotNull(null);
        //Preconditions.checkNotNull(null, "不能为空!");
        //Preconditions.checkNotNull(null, "%s不能为空!","name");

        Preconditions.checkArgument("a".equals(new String("a")));
        Preconditions.checkState(true);
        Preconditions.checkState(true, "检查状态异常!");
        Preconditions.checkElementIndex(3, Arrays.asList("a").size());
    }
}
