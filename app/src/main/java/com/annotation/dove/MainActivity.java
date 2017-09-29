package com.annotation.dove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.deemons.dove.Dove;

public class MainActivity extends AppCompatActivity {

    @Dove
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test("test param",88);
    }

    @Dove
    private void test(String s,int i) {
        Log.d("","do test()");
    }
}
