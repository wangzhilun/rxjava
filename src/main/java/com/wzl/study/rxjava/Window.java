package com.wzl.study.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.concurrent.TimeUnit;

/**
 * 统计每10秒钟调用次数
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191230 17:20:52
 */
public class Window {

    public static void main(String[] args) throws InterruptedException {
        PublishSubject<Integer> publishSubject = PublishSubject.create();
        Subject<Integer> subject = publishSubject.toSerialized();
        subject.window(5, TimeUnit.SECONDS)
                .flatMap(new Function<Observable<Integer>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<Integer> apply(Observable<Integer> integerObservable) throws Exception {
                        return integerObservable.reduce(new BiFunction<Integer, Integer, Integer>() {
                            @Override
                            public Integer apply(Integer integer, Integer integer2) throws Exception {
                                return integer + integer2;
                            }
                        }).toObservable();
                    }
                })
                .window(3, 1)
                .flatMap(new Function<Observable<Object>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<Object> apply(Observable<Object> objectObservable) throws Exception {
                        return objectObservable.reduce(new BiFunction<Object, Object, Object>() {
                            @Override
                            public Object apply(Object integer, Object integer2) throws Exception {
                                return (Integer) integer + (Integer) integer2;
                            }
                        }).toObservable();
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        System.out.println(o);
                    }
                });
        for (int i = 0; i < 100; ++i) {
            if (i < 30) {
                subject.onNext(1);
            } else {
                subject.onNext(2);
            }
            Thread.sleep(1000);
        }
    }
}
