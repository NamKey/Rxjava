package com.itvillege.chapter3;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class MissingBackpresseureException {
    public static void main(String[] args) throws InterruptedException{
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println(data))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            System.out.println("# Pending..");
                            Thread.sleep(1000L);
                            System.out.println(data);
                        },
                        error -> System.err.println(error), // MissingBackPressureException
                        () -> System.err.println("End")
                ); // Test 진행
        Thread.sleep(2000L);
    }

}
