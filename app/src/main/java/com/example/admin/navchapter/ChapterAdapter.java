package com.example.admin.navchapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.navchapter.model.Chapter;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter <ChapterAdapter.ViewHolder>{



    static ViewHolder holderGetPosition;
    ArrayList<Chapter> chapters;

    public ChapterAdapter(ArrayList<Chapter>menu) {
        this.chapters = menu;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView chapterNum;
        TextView chapterTitle;

        public ViewHolder(final View itemView) {

            super(itemView);
            chapterNum = itemView.findViewById(R.id.chapterNum);
            chapterTitle = itemView.findViewById(R.id.chapterTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(view.getContext(),view.getTag()+"",Toast.LENGTH_SHORT).show();
                }
            });

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
    public void onBindViewHolder(@NonNull final ChapterAdapter.ViewHolder holder, final int position) {

        holderGetPosition = holder;
        Chapter chapter = chapters.get(position);
        holder.chapterNum.setText(chapter.getNumChapter()+"");
        holder.chapterTitle.setText(chapter.getTitleChapter());
        holder.itemView.setTag(position);



        }

    @Override
    public int getItemCount() {
        return chapters.size();
    }


}
