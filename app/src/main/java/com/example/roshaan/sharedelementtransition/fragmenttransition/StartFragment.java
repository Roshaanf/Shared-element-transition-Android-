package com.example.roshaan.sharedelementtransition.fragmenttransition;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.sharedelementtransition.R;
import com.example.roshaan.sharedelementtransition.activitytransition.EndActivity;
import com.example.roshaan.sharedelementtransition.databinding.FragmentStartBinding;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class StartFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    FragmentStartBinding binding;

    public static StartFragment newInstance() {

        Bundle args = new Bundle();

        StartFragment fragment = new StartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_start,container,false);



        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    binding.textView.setTransitionName(getString(R.string.text_view_transition_name));

                    EndFragment endFragment=EndFragment.newInstance();


                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .addSharedElement(binding.imageView, binding.imageView.getTransitionName())
                            .addSharedElement(binding.textView,binding.textView.getTransitionName())
                            .replace(R.id.linearLayout, endFragment)
                            .addToBackStack(null)
                            .commit();

                }
            }
        });




        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
