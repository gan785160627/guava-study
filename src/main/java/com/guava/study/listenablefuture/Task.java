package com.guava.study.listenablefuture;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    public String args;
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("任务：" + args);
        if ("task3".equalsIgnoreCase(args)) {
            throw new Exception(args + " Exception");
        }
        return args + " done";
    }
}
