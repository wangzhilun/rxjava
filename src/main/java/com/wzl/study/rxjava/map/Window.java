package com.wzl.study.rxjava.map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

/**
 * 窗口,发射这个窗口内的数据
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191230 16:04:17
 */
public class Window {

    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .window(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Observable<Long>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Observable<Long> longObservable) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        Thread.sleep(10 * 1000);
    }
}
