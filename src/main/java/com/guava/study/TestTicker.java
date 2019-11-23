package com.guava.study;

import com.google.common.base.Ticker;

public class TestTicker extends Ticker {
    private long start = Ticker.systemTicker().read();
    private long elapsedNano = 0;

    @Override
    public long read() {
        System.out.println("当前模拟时间："+(start + elapsedNano));
        return start + elapsedNano;
    }

    public void addElapsedTime(long elapsedNano) {
        this.elapsedNano = elapsedNano;
    }
}
