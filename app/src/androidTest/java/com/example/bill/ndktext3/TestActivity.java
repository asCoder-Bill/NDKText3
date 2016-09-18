package com.example.bill.ndktext3;

import android.content.Context;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

/**
 * 作者：Bill on 2016/9/18 0018 00:37
 * 备注：安卓测试Activity
 */
public class TestActivity extends ActivityInstrumentationTestCase2<MainActivity> {
    private Context ctx;

    public TestActivity() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ctx = getActivity().getApplication();
    }

    public void testStart(){
        Intent intent = new Intent(ctx, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(intent);     //还可以ctx.startActivity(Intent[] intents); 多个Activity
        try {
            Thread.sleep(10000);   //让测试停留10s 不至于结束太快  导致看见activity“闪退”
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
