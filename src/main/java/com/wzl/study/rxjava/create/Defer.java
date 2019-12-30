package com.wzl.study.rxjava.create;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.Callable;

/**
 * defer只会在有观察者订阅时候创建Observable,并且为每个观察者创建一个新的Observable,单独的数据序列。
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191230 15:20:47
 */
public class Defer {

    public static void main(String[] args) {
        Observable.defer(new Callable<ObservableSource<String>>() {
            @Override
            public ObservableSource<String> call() throws Exception {
                return (ObservableSource) observer -> {
                    for (int i = 0; i < 10; i++) {
                        observer.onNext("handle" + i);
                    }
                    observer.onComplete();
                };
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });
    }
}
