package com.guava.study.service;

import com.google.common.util.concurrent.AbstractIdleService;


public class DefaultService extends AbstractIdleService {
    @Override
    protected void startUp() throws Exception {
        System.out.println("DefaultService starting!");
    }

    @Override
    protected void shutDown() throws Exception {
        System.out.println("DefaultService stopping!");
    }
}




