package guava.eventbus.listener;

import com.google.common.eventbus.EventBus;

public class SimpleEventBusTest {


    public static void main(String[] args) {

        final EventBus eventBus = new EventBus();
        eventBus.register(new SimpleListener());
        System.out.println("post the simple event...");
        eventBus.post("Simple Event");
    }
}
