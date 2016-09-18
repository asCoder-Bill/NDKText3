package com.example.bill.ndktext3;

import android.test.InstrumentationTestCase;
import android.util.Log;

import rx.Observer;
import rx.subjects.PublishSubject;

/**
 * 作者：Bill on 2016/9/18 0018 00:00
 * 备注：Android测试
 *在androidTest下新建一个java类，并且继承自InstrumentationTestCase
 * 编写一个public void的方法，但是必须要是方法名以test打头，比如testPublishSubject，并不需要@Test注解
 */
public class TextAndroidddd extends InstrumentationTestCase{
    private static final String LOG_TAG = "test";

    public void testPublishSubject(){
        PublishSubject<String> stringPublishSubject = PublishSubject.create();
        stringPublishSubject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(LOG_TAG, "Observable completed");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d(LOG_TAG, "Observable consumed:" +s);
            }
        });

        stringPublishSubject.onNext("Hello World!");
        stringPublishSubject.onCompleted();
    }

}
