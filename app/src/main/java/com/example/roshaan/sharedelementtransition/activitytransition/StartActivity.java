package com.example.roshaan.sharedelementtransition.activitytransition;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roshaan.sharedelementtransition.R;


public class StartActivity extends AppCompatActivity {

//    ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_start);
        setContentView(R.layout.activity_start);
    }

    public void startTransition(View v) {

        TextView textView= findViewById(R.id.textView);
        ImageView imageView= findViewById(R.id.imageView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textView.setTransitionName(getString(R.string.text_view_transition_name));


            Pair<View, String> pair1 = Pair.create((View) imageView, imageView.getTransitionName());
            Pair<View, String> pair2 = Pair.create((View) textView, textView.getTransitionName());

            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(this, pair1, pair2);
            startActivity(new Intent(this, EndActivity.class)
                    , options.toBundle());
        } else {
            startActivity(new Intent(this, EndActivity.class));
        }

    }
}
