package com.example.roshaan.sharedelementtransition.activitytransition;


import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roshaan.sharedelementtransition.R;


public class EndActivity extends AppCompatActivity {

//    ActivityEndBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);

//        binding= DataBindingUtil.setContentView(this,R.layout.activity_end);
        setContentView(R.layout.activity_end);
        TextView tv=(TextView) findViewById(R.id.textView);
        ImageView iv= findViewById(R.id.imageView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

        }

//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            tv.setTransitionName(getString(R.string.text_view_transition_name));
//        }
    }
}
