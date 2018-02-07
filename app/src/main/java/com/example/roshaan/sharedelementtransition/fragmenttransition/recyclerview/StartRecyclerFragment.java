package com.example.roshaan.sharedelementtransition.fragmenttransition.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.sharedelementtransition.Callback;
import com.example.roshaan.sharedelementtransition.DataRepository;
import com.example.roshaan.sharedelementtransition.R;
import com.example.roshaan.sharedelementtransition.adapter.Adapter;
import com.example.roshaan.sharedelementtransition.databinding.FragmentStart2Binding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StartRecyclerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class StartRecyclerFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    FragmentStart2Binding binding;

    public static StartRecyclerFragment newInstance() {

        Bundle args = new Bundle();

        StartRecyclerFragment fragment = new StartRecyclerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_start2,container,false);

        Adapter adapter=new Adapter(DataRepository.getItems(), new Callback() {
            @Override
            public void revoke(List<Object> objects) {
               mListener.onRecyclerStartFragmentInteraction(objects);
            }
        });


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
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
        void onRecyclerStartFragmentInteraction(List<Object> objects);
    }
}
