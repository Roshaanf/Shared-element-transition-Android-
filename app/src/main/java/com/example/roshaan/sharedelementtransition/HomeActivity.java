package com.example.roshaan.sharedelementtransition;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roshaan.sharedelementtransition.activitytransition.StartActivity;
import com.example.roshaan.sharedelementtransition.databinding.ActivityHomeBinding;
import com.example.roshaan.sharedelementtransition.fragmenttransition.EndFragment;
import com.example.roshaan.sharedelementtransition.fragmenttransition.StartFragment;

public class HomeActivity extends AppCompatActivity implements
        StartFragment.OnFragmentInteractionListener,
        EndFragment.OnFragmentInteractionListener {

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
}

