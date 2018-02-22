package guava.functional;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class StopWatchExample {

    private final static Logger LOGGER = LoggerFactory.getLogger(StopWatchExample.class);

    public static void main(String[] args) throws InterruptedException {

        process("123");
    }

    private static void process(String orderNo) throws InterruptedException {

        LOGGER.info("start process the order [{}]", orderNo);
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.MILLISECONDS.sleep(2000);

        LOGGER.info("The orderNo [{}] process successful and elapsed [{}] second.", orderNo, stopwatch.stop().elapsed(TimeUnit.SECONDS));


    }
}
