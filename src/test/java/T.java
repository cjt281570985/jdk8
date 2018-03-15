import com.google.common.base.*;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class T {

    public static void main(String[] args) throws InterruptedException {

        Stopwatch stopwatch = Stopwatch.createStarted();

        TimeUnit.SECONDS.sleep(2);

        stopwatch.stop();

        System.out.println(stopwatch.elapsed(MILLISECONDS));
        System.out.println(stopwatch);

    }

}
