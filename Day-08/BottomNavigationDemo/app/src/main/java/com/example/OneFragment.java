package com.example;

import androidx.lifecycle.ViewModelProviders;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class OneFragment extends Fragment {

    private OneViewModel mViewModel;

    public static OneFragment newInstance() {
        return new OneFragment();
    }

    ImageView mImageView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fragment, container, false);
        mImageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OneViewModel.class);
        mImageView.setRotation(mViewModel.rotationPosition);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImageView,"rotation",0,0);
        objectAnimator.setDuration(500);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!objectAnimator.isRunning()) {
                    objectAnimator.setFloatValues(mImageView.getRotation(),mImageView.getRotation() + 100);
                    mViewModel.rotationPosition += 100;
                    objectAnimator.start();
                }
            }
        });

        // TODO: Use the ViewModel
    }

}