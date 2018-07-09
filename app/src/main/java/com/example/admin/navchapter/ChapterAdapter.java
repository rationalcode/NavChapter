package com.example.admin.navchapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.navchapter.model.Chapter;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter <ChapterAdapter.ViewHolder> {



    ArrayList<Chapter> chapters;

    public ChapterAdapter(ArrayList<Chapter>menu) {
        this.chapters = menu;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView chapterNum;
        TextView chapterTitle;

        public ViewHolder(View itemView) {

            super(itemView);
            chapterNum = itemView.findViewById(R.id.chapterNum);
            chapterTitle = itemView.findViewById(R.id.chapterTitle);
        }
    }

    @NonNull
    @Override
    public ChapterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = null;
        View v = inflater.from(parent.getContext())
                .inflate(R.layout.chapter_menu_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterAdapter.ViewHolder holder, int position) {

        Chapter chapter = chapters.get(position);
        holder.chapterNum.setText(chapter.getNumChapter()+"");
        holder.chapterTitle.setText(chapter.getTitleChapter());

    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }


}
