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

import java.time.chrono.MinguoChronology;
import java.util.Random;

public class ThreeFragment extends Fragment {

    private ThreeViewModel mViewModel;

    ImageView mImageView;

    public static ThreeFragment newInstance() {
        return new ThreeFragment();
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
        mViewModel = ViewModelProviders.of(this).get(ThreeViewModel.class);
        mImageView.setX(mImageView.getX() + mViewModel.dx);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImageView,"x",0,0);
        objectAnimator.setDuration(500);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!objectAnimator.isRunning()) {
                    float dx = new Random().nextBoolean() ? 100 : -100;
                    objectAnimator.setFloatValues(mImageView.getX(),mImageView.getX() + dx);
                    mViewModel.dx += dx;
                    objectAnimator.start();
                }
            }
        });
    }

}