package chapter5;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.util.concurrent.*;
import com.guava.study.listenablefuture.Task;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ListenableFutureTest {
    ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
    FutureCallback<String> futureCallback = new FutureCallback<String>() {
        @Override
        public void onSuccess(String result) {
            System.out.println("Futures.addCallback 能带返回值:" + result);
        }

        @Override
        public void onFailure(Throwable t) {
            System.out.println("出错:" + t.getMessage());
        }
    };
    FutureCallback<List<String>> futureListCallback = new FutureCallback<List<String>>() {
        @Override
        public void onSuccess(List<String> results) {
            System.out.println("Futures.addCallback 能带返回值:" + Joiner.on(";").join(results));
        }

        @Override
        public void onFailure(Throwable t) {
            System.out.println("出错:" + t.getMessage());
        }
    };

    @Test
    public void testCallback() {
        //test addListener addCallback
        System.out.println("主线程start");

        Task task1 = new Task();
        task1.args = "task1";
        Task task2 = new Task();
        task2.args = "task2";
        Task task3 = new Task();
        task3.args = "task3";
        ListenableFuture<String> future = pool.submit(task1);
        ListenableFuture<String> future2 = pool.submit(task2);
        ListenableFuture<String> future3 = pool.submit(task3);

        future2.addListener(() -> System.out.println("addListener 不能带返回值"), pool);
        Futures.addCallback(future, futureCallback, pool);
        Futures.addCallback(future3, futureCallback, pool);
        System.out.println("主线程end");
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

    @Test
    public void testTransform() {
        //test Futures.transform
        Task task1 = new Task();
        task1.args = "task1";
        ListenableFuture<String> future = pool.submit(task1);
        Function<String, String> transformFunc =
                new Function<String, String>() {
                    @Override
                    public String apply(String result) {
                        return result + " transform done";
                    }
                };

        ListenableFuture transformFuture = Futures.transform(future, transformFunc, pool);
        try {
            System.out.println(future.get());
            System.out.println(transformFuture.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAllAsList() {
        //test Futures.allAsList
        System.out.println("主线程start");
        Task task1 = new Task();
        task1.args = "task1";
        Task task4 = new Task();
        task4.args = "task4";
        ListenableFuture<String> future = pool.submit(task1);
        ListenableFuture<String> future4 = pool.submit(task4);
        ListenableFuture<List<String>> futureList = Futures.allAsList(future, future4);
        Futures.addCallback(futureList, futureListCallback, pool);
        System.out.println("主线程end");
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

    @Test
    public void testCheckedFuture() {
        //test CheckedFuture
        Task task3 = new Task();
        task3.args = "task3";
        ListenableFuture<String> future3 = pool.submit(task3);
        CheckedFuture checkedFuture = Futures.makeChecked(future3, e -> new Exception("checked future Exception"));
        try {
            future3.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            checkedFuture.checkedGet();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
