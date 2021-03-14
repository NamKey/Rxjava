package com.itvillege.chapter3;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BackpressureBufferExample {
    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println("#interval doOnNext()" + data))
                .onBackpressureBuffer(
                        2,
                        () -> System.out.println("overflow!"),
                        BackpressureOverflowStrategy.DROP_OLDEST)
                .doOnNext(data -> System.out.println("#onBackpressureBuffer doOnNext()" + data))
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            Thread.sleep(1000);
                            System.out.println("" + data);
                        },
                        error -> System.err.println("" + error)
                );

        Thread.sleep(2000L);
    }
}
