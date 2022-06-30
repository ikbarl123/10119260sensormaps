package com.alimuntung.a10119260sensormaps.Presenter.info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alimuntung.a10119260sensormaps.R;
import com.alimuntung.a10119260sensormaps.View.InfoAdapter;

// Ikbar Laudza Alviansyah
// IF-7
// 10119260
public class InfoFragment extends Fragment {

    private static final int PAGES=5;
    private ViewPager2 viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = getView().findViewById(R.id.pager);
        viewPager.setAdapter(new InfoAdapter(getActivity()));
    }

}