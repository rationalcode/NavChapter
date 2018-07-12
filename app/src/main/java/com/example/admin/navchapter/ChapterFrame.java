package com.example.admin.navchapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.navchapter.model.Chapter;
import com.example.admin.navchapter.model.abstractFragment;

import java.util.ArrayList;

public class ChapterFrame extends abstractFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view =  inflater.inflate(R.layout.chapter_menu_fragment, container, false);


        ArrayList<Chapter> chapters = new ArrayList<>();
        for (int i = 0; i < 30; i++) {

            chapters.add(new Chapter(i+1," Chapter "+(i+1),"По умолчанию, текст в TextView нельзя выделить для копирования. Но в API 11 появилась такая возможность, которая может пригодиться. Делается либо при помощи XML-атрибута android:textIsSelectable, либо через метод setTextIsSelectable().\n" +
                    "\n" +
                    "Добавьте в разметку два компонента TextView и одно текстовое поле EditText для вставки скопированного текста. У первой текстовой метки установим возможность выделения текста декларативно.\n" +
                    "\n"));

        }

        RecyclerView recyclerView = view.findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ChapterAdapter adapter = new ChapterAdapter (chapters);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
