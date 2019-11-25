package chapter5;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.Uninterruptibles;
import com.guava.study.service.DefaultAbstractExecutionThreadService;
import com.guava.study.service.DefaultAbstractScheduledService;
import com.guava.study.service.DefaultService;
import com.guava.study.service.TestListener;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ServiceTest {

    @Test
    public void testAbstractIdleService() {
        //AbstractIdleService
        DefaultService service = new DefaultService();
        try {
            service.addListener(new TestListener(), MoreExecutors.sameThreadExecutor());
            service.startAsync().awaitRunning();
            System.out.println(service.state());
            service.stopAsync().awaitTerminated();
            System.out.println(service.state());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAbstractExecutionThreadService() {
        //AbstractExecutionThreadService
        DefaultAbstractExecutionThreadService service = new DefaultAbstractExecutionThreadService();
        try {
            service.addListener(new TestListener(), MoreExecutors.sameThreadExecutor());
            service.startAsync().awaitRunning();
            Uninterruptibles.sleepUninterruptibly(30, TimeUnit.SECONDS);
            service.stopAsync().awaitTerminated();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAbstractScheduledService() {
        //AbstractScheduledService
        DefaultAbstractScheduledService service = new DefaultAbstractScheduledService();
        try {
            service.addListener(new TestListener(), MoreExecutors.sameThreadExecutor());
            service.startAsync().awaitRunning();
            while (service.isRunning()) {
                Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testServiceManager() {
        //ServiceManager
        DefaultService service1 = new DefaultService();
        DefaultAbstractExecutionThreadService service2 = new DefaultAbstractExecutionThreadService();
        DefaultAbstractScheduledService service3 = new DefaultAbstractScheduledService();
        ServiceManager serviceManager = new ServiceManager(Lists.newArrayList(service1, service2, service3));
        serviceManager.addListener(new ServiceManager.Listener() {
            @Override
            public void stopped() {
                super.stopped();
                System.out.println("stopped");
            }
        });
        serviceManager.startAsync().awaitHealthy();
        Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);
        serviceManager.stopAsync().awaitStopped();
    }
}
