package guava.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractListener.class);

    @Subscribe
    public void commonTask(String event) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("the event [{}] ---commmonTask--- handle by {}", event, this.getClass().getSimpleName());
        }
    }
}
