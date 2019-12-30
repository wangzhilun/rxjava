package com.wzl.study.rxjava.map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 定期收集Observable的数据放进一个数据包裹,然后发送一个list
 * 当消费者消费速度跟不上时,支持按照时间限制速度
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191230 15:47:25
 */
public class Buffer {

    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .buffer(3)
                .subscribe(new Consumer<List<Long>>() {
                    @Override
                    public void accept(List<Long> longs) throws Exception {
                        System.out.println("common: " + longs);
                    }
                });
        //back pressure
        Observable.interval(1, TimeUnit.SECONDS)
                .buffer(3, TimeUnit.SECONDS, 3)
                .subscribe(new Consumer<List<Long>>() {
                    @Override
                    public void accept(List<Long> longs) throws Exception {
                        System.out.println("backPressure: " + longs);
                    }
                });
        //skip 根据skip的大小会重叠(skip<count)或者有间隙(skip>count)
        Observable.interval(1, TimeUnit.SECONDS)
                .buffer(3, 1)
                .subscribe(new Consumer<List<Long>>() {
                    @Override
                    public void accept(List<Long> longs) throws Exception {
                        System.out.println("skip: " + longs);
                    }
                });
        Thread.sleep(10 * 1000);
    }

}
