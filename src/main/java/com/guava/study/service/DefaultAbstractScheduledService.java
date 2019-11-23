package com.guava.study.service;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AbstractScheduledService;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DefaultAbstractScheduledService extends AbstractScheduledService {
    private List<String> list;

    @Override
    public void runOneIteration() {
        System.out.println("Add element to list ..........");
        list.add("test");
        if(list.size()>10){
            System.out.println("ShutDown Scheduled job ..........");
            this.stopAsync().awaitTerminated();
        }
    }

    @Override
    protected void startUp() throws Exception {
        System.out.println("Scheduled Job start ..........");
        list = Lists.newArrayList();
    }

    @Override
    protected void shutDown() throws Exception {
        System.out.println("Scheduled Job end ..........");
    }

    @Override
    protected Scheduler scheduler() {
        return Scheduler.newFixedRateSchedule(0,1, TimeUnit.SECONDS);
    }
}
