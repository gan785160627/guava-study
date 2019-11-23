package com.guava.study.service;

import com.google.common.util.concurrent.Service;

public class TestListener extends Service.Listener {
    @Override
    public synchronized void starting() {
        System.out.println("listener: service starting!");
    }

    @Override
    public synchronized void running() {
        System.out.println("listener: service running!");
    }

    @Override
    public synchronized void stopping(Service.State from) {
        System.out.println(String.format("listener: service stopping from %s!", from));
    }

    @Override
    public synchronized void terminated(Service.State from) {
        System.out.println(String.format("listener: service terminated from %s!", from));
    }

}
