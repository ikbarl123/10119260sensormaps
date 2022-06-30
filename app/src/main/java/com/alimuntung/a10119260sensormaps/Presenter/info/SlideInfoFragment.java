package com.alimuntung.a10119260sensormaps.Presenter.info;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alimuntung.a10119260sensormaps.R;

// Ikbar Laudza Alviansyah
// IF-7
// 10119260
public class SlideInfoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(
                R.layout.fragment_slide_info, container, false);
    }
}