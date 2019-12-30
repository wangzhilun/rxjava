package com.wzl.study.rxjava.fliter;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * 过滤重复数据
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191230 16:14:01
 */
public class Distinct {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 1, 2, 3)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }
}
