import com.google.common.base.*;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.*;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class T {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(20);
            CountDTO dto = new CountDTO("c" + i, num);
        }



    }

}
