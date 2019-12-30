package com.wzl.study.rxjava.fliter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

/**
 * 过了一段时间还没有发射数据时发射一个数据
 * 会过滤掉发射过快的数据
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191230 16:08:35
 */
public class Debounce {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(2, TimeUnit.SECONDS)
                .debounce(1, TimeUnit.SECONDS)
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
