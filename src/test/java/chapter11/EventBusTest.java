package chapter11;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.guava.study.Person;
import org.junit.Test;

public class EventBusTest {
    final EventBus eventBus = new EventBus();
    class EventBusRecorder {
        @Subscribe
        public void recordPerson(Person person) {
            System.out.println(person);
        }

        @Subscribe
        public void recordString(String string) {
            System.out.println(string);
        }

        @Subscribe
        public void lister(DeadEvent event) {
            System.out.printf("%s=%s from dead events%n", event.getSource().getClass(), event.getEvent());
        }
    }

    @Test
    public void test1() {
        eventBus.post("this is a test string!");
    }

    @Test
    public void test2() {
        Person person = new Person(1,"a","b",1);
        eventBus.register(new EventBusRecorder());
        eventBus.post(person);
    }

    @Test
    public void test3() {
        eventBus.register(new EventBusRecorder());
        eventBus.post(1);
    }
}
