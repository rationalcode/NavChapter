package com.example.admin.navchapter.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.navchapter.R;

public class ChapterTextFragment extends abstractFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.chapter_text, container, false);
    }
}
