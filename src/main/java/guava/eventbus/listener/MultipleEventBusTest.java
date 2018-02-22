package guava.eventbus.listener;

import com.google.common.eventbus.EventBus;

public class MultipleEventBusTest {


    public static void main(String[] args) {

        final EventBus eventBus = new EventBus();
        eventBus.register(new MultipleEventListeners());
        System.out.println("post the string event...");
        eventBus.post("I am a string Event");
        System.out.println("post the int event...");
        eventBus.post(100);
    }
}
