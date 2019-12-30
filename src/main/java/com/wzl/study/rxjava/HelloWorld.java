package com.wzl.study.rxjava;


import io.reactivex.Flowable;
import io.reactivex.Observable;

public class HelloWorld {

    public static void main(String[] args) {
        hello("王志伦", "world");
    }

    public static void hello(String... names) {
        Flowable.fromArray(names).subscribe(s -> System.out.println("hello" + s));
    }

}
