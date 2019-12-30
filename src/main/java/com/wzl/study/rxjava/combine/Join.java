package com.wzl.study.rxjava.combine;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 只要在另一个Observable发射的数据定义的时间窗口内,这个Observable发射了一条数据,就结合两个Observable发射的数据
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191230 16:17:40
 */
public class Join {

    public static void main(String[] args) {
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Integer> just = Observable.just(1, 2, 3);

    }
}
