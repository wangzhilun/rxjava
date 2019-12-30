package com.wzl.study.rxjava.create;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 将其他对象转换为Observable，可以把iterable,array,future转换为observable
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191230 15:29:48
 */
public class From {

    public static void main(String[] args) {
        Observable.fromArray("王志伦", "world")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("hello" + s);
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
