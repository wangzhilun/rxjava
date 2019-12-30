package com.wzl.study.rxjava.map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

/**
 * 将发射的数据映射为其他值
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191230 15:59:13
 */
public class Map {

    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return aLong + " map to string";
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
        Thread.sleep(10 * 1000);
    }
}
