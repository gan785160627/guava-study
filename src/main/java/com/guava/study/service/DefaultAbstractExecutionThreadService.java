package com.guava.study.service;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class DefaultAbstractExecutionThreadService extends AbstractExecutionThreadService {
    @Override
    public void run() {
        while (this.isRunning()) {
            try {
                Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
                System.out.println("do work.....");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
