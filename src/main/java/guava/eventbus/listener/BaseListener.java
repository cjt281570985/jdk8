package guava.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseListener extends AbstractListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseListener.class);

    @Subscribe
    public void baseTask(String event) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("the event [{}] ---baseTask--- handle by {}", event, this.getClass().getSimpleName());
        }
    }
}
