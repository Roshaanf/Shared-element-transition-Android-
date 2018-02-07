package com.example.roshaan.sharedelementtransition.fragmenttransition.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.roshaan.sharedelementtransition.R;
import com.example.roshaan.sharedelementtransition.databinding.FragmentEnd2Binding;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EndRecyclerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class EndRecyclerFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    public static final String IMAGE_TRANSITION = "OO";
    public static final String TEXT_TRANSITION = "OOO";
    public static final String TEXT = "OOOO";
    public static final String IMAGE_ID = "OOOOO";

    FragmentEnd2Binding binding;

    public static EndRecyclerFragment newInstance(String imageTransitionName, String textViewTransitionName, int imageId, String text) {

        Bundle args = new Bundle();
        args.putString(EndRecyclerFragment.IMAGE_TRANSITION, imageTransitionName);
        args.putString(EndRecyclerFragment.TEXT_TRANSITION, textViewTransitionName);
        args.putInt(EndRecyclerFragment.IMAGE_ID,imageId);
        args.putString(EndRecyclerFragment.TEXT,text);

        EndRecyclerFragment fragment = new EndRecyclerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_end2, container, false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.textView.setTransitionName(getArguments().getString(EndRecyclerFragment.TEXT_TRANSITION));
            binding.imageView.setTransitionName(getArguments().getString(EndRecyclerFragment.IMAGE_TRANSITION));
            System.out.println("Hello "+binding.textView.getTransitionName());
            System.out.printf("Hello"+binding.imageView.getTransitionName());
        }

        Glide.with(this)
                .load(getArguments().getInt(EndRecyclerFragment.IMAGE_ID))
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        Toast.makeText(getContext(), "load failed"+e.getMessage(), Toast.LENGTH_SHORT).show();
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        Toast.makeText(getContext(), "Resourceredy", Toast.LENGTH_SHORT).show();
//                        return false;
//                    }
//                })
                .apply(new RequestOptions()
                .centerCrop())
                .into(binding.imageView);

        binding.textView.setText(getArguments().getString(EndRecyclerFragment.TEXT));

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
        void onFragmentInteraction(Uri uri);
    }
}
