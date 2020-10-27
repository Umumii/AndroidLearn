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

public class TwoFragment extends Fragment {

    private TwoViewModel mViewModel;

    ImageView mImageView;

    public static TwoFragment newInstance() {
        return new TwoFragment();
    }

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
        mViewModel = ViewModelProviders.of(requireActivity()).get(TwoViewModel.class);
        mImageView.setScaleX(mViewModel.scaleX);
        mImageView.setScaleY(mViewModel.scaleY);
        final ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(mImageView,"scaleX",0,0);
        final ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(mImageView,"scaleY",0,0);
        objectAnimatorX.setDuration(500);
        objectAnimatorY.setDuration(500);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!objectAnimatorX.isRunning()) {
                    objectAnimatorX.setFloatValues(mImageView.getScaleX() + 0.1f);
                    objectAnimatorY.setFloatValues(mImageView.getScaleY() + 0.1f);
                    mViewModel.scaleX += 0.1f;
                    mViewModel.scaleY += 0.1f;
                    objectAnimatorX.start();
                    objectAnimatorY.start();
                }
            }
        });
    }

}