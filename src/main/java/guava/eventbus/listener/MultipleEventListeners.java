package guava.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultipleEventListeners {

    private final static Logger LOGGER = LoggerFactory.getLogger(MultipleEventListeners.class);

    @Subscribe
    public void task1(String event) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Received event [{}] ---task1---", event);
        }
    }

    @Subscribe
    public void task2(String event) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Received event [{}] ---task2---", event);
        }
    }

    @Subscribe
    public void task2int(Integer event) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Received event [{}] ---task2int---", event);
        }
    }
}
