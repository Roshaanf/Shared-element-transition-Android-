package com.example.roshaan.sharedelementtransition;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roshaan.sharedelementtransition.activitytransition.StartActivity;
import com.example.roshaan.sharedelementtransition.databinding.ActivityHomeBinding;
import com.example.roshaan.sharedelementtransition.fragmenttransition.EndFragment;
import com.example.roshaan.sharedelementtransition.fragmenttransition.StartFragment;
import com.example.roshaan.sharedelementtransition.fragmenttransition.recyclerview.EndRecyclerFragment;
import com.example.roshaan.sharedelementtransition.fragmenttransition.recyclerview.StartRecyclerFragment;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements
        StartFragment.OnFragmentInteractionListener,
        EndFragment.OnFragmentInteractionListener,
        StartRecyclerFragment.OnFragmentInteractionListener ,
        EndRecyclerFragment.OnFragmentInteractionListener{

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        makeButtonsVisible();

    }


    public void makeButtonsVisible() {

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {

                if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                    binding.button.setVisibility(View.VISIBLE);
                    binding.button2.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void activity(View v) {

        startActivity(new Intent(this, StartActivity.class));
    }


    public void fragmentRecycler(View v){

        binding.button.setVisibility(View.GONE);
        binding.button2.setVisibility(View.GONE);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.linearLayout, StartRecyclerFragment.newInstance())
                .addToBackStack(null)
                .commit();

    }
    public void fragment(View v) {

        binding.button.setVisibility(View.GONE);
        binding.button2.setVisibility(View.GONE);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.linearLayout, StartFragment.newInstance())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onRecyclerStartFragmentInteraction(List<Object> objects) {

        ImageView iv= (ImageView) objects.get(0);
        TextView tv= (TextView) objects.get(1);
        int imageId= (int) objects.get(2);
        String text= (String) objects.get(3);

        System.out.println("Hello");
        System.out.println("Hello "+imageId);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getSupportFragmentManager().beginTransaction()
                    .addSharedElement(iv,iv.getTransitionName())
                    .addSharedElement(tv,tv.getTransitionName())
                    .replace(R.id.linearLayout,EndRecyclerFragment.newInstance(iv.getTransitionName(),tv.getTransitionName(),
                           imageId,text ))
                    .addToBackStack(null)
                    .commit();
        }
    }
}

