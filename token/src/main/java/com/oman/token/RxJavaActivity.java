package com.oman.token;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Thread.currentThread().getName(); == Android的主线程

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Log.i("aaa", "first thread:" + Thread.currentThread().getName());//子
                e.onNext("first");
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        Log.i("aaa", "test thread:" + Thread.currentThread().getName());//main
                        return s + "-test";
                    }
                })
                /***
                 * subscribeOn直接将它的上一个Observer包装成一个Runnable,run方法中执行source.subscribe(subscribeOnObserver)
                 * 在subscribeActual中调用scheduler.scheduleDirect(new SubscribeTask(parent))，直接放入线程池或者主Handler中执行
                 * 所以subscribeOn是负责上面线程切换的一个调度机制
                 *
                 * 当有多个subscribeOn调度的时候，当然以第一个为准; 执行的时候是从下往上封包任务，相当于在主线程中执行子线程的任务，所以还是子线程
                 * 如果subscribeOn附近(上面没有observerOn,下面没有subscribeOn)没有线程调度的话，那subscribeOn也会负责附近的线程调度
                 * 如果subscribeOn上面只有observerOn的话，那subscribeOn也会负责observerOn上面的线程调度
                 *
                 * Observable.create
                 *  .observerOn() //这里也会处理下面subscribe中的线程调度
                 *  .subscribeOn()//这里也会处理上面create中的线程调度
                 *  .subscribe()
                 */
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(String s) throws Throwable {
//                        Log.i("aaa", "test2 thread:" + Thread.currentThread().getName());
//                        return s + "-test2";
//                    }
//                })
                .subscribeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.io())
                /**
                 * observeOn是在subscribeActual中正常执行source.subscribe(new ObserveOnObserver<>(observer, w);
                 * 把后面的一个Observer和Scheduler包装成一个Observer, 等到将来调用到这个Observer.onNext的时候再切换线程执行
                 * 所以observeOn是只负责下面任务切换的一个调度机制
                 *
                 * 如果有多个observeOn的话，执行的是最后一个observeOn，其实都执行了，不过有效的是最后一个
                 * 因为observeOn是将后面的Observer包装成Observer，等到将来执行的时候切换线程，所以是最后一个有效；不像subscribeOn直接执行
                 *
                 * observeOn只负责紧挨着下面的线程调度，其余的在哪里调用就在哪里调用
                 * 如果observerOn下面只有subscribeOn的话，也会负责subscribeOn下面的线程调度
                 */
//                .observeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.io())
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(String s) throws Exception {
//                        Log.i("aaa", "second thread:" + Thread.currentThread().getName() + "--s:" + s);
//                        return s + "-second";
//                    }
//                })
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("aaa", "onSubscribe thread:" + Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("aaa", "onNext thread:" + Thread.currentThread().getName() + "--s:" + s);//main
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
