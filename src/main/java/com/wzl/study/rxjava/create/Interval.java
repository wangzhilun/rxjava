package com.wzl.study.rxjava.create;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * 创建一个按固定时间间隔发射整数序列的Observable
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191230 15:38:15
 */
public class Interval {

    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println(aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");
                    }
                });
        Thread.sleep(10 * 1000);
    }
}
