package com.example.admin.navchapter;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.admin.navchapter.model.Chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterFrame extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view =  inflater.inflate(R.layout.chapter_menu_fragment, container, false);


        ArrayList<Chapter> chapters = new ArrayList<>();
        for (int i = 0; i < 30; i++) {

            chapters.add(new Chapter(i+1," Chapter "+(i+1),"fdhsfdfshahfdhfhdagsfdgha"));

        }

        RecyclerView recyclerView = view.findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ChapterAdapter adapter = new ChapterAdapter (chapters);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
