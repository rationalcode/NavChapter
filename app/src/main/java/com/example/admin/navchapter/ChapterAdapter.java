package com.example.admin.navchapter;

import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.navchapter.model.Chapter;
import com.example.admin.navchapter.model.ChapterTextFragment;

import java.util.ArrayList;

import static com.example.admin.navchapter.Main.chapterFrame;
import static com.example.admin.navchapter.Main.chapterText;
import static com.example.admin.navchapter.Main.currentFragmentId;
import static com.example.admin.navchapter.Main.defaultFragment;
import static com.example.admin.navchapter.Main.fragmentManager;
import static com.example.admin.navchapter.Main.replaceFragment;
import static com.example.admin.navchapter.Main.transaction;

public class ChapterAdapter extends RecyclerView.Adapter <ChapterAdapter.ViewHolder>{


    FragmentActivity fragmentActivity;
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

                    //chapterTextFragment.getActivity().getFragmentManager().beginTransaction();

                    Chapter chapter = chapters.get((Integer) view.getTag());

                    android.support.v4.app.FragmentManager fm;
                    replaceFragment(new ChapterTextFragment(), );
//                    transaction.replace(currentFragmentId, new ChapterTextFragment());
//
//                    transaction.commit();
                    chapterText.setText(chapter.getTextChapter());
                    //Toast.makeText(view.getContext(),view.getTag()+"",Toast.LENGTH_SHORT).show();
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
