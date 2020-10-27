package com.example;

/*
 * RoomBasic
 * MyAdapter
 *
 * Created by Tianta on 2020/09/07.
 * Copyright (c) 2020 甜塔. All rights reserved.
 * Describe: xxx.
 */

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Word> allWords = new ArrayList<>();
    boolean useCardView;

    public void setAllWords(List<Word> allWords) {
        this.allWords = allWords;
    }

    public MyAdapter(boolean useCardView) {
        this.useCardView = useCardView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView;
        if (useCardView) {
            itemView = inflater.inflate(R.layout.cell_card,parent,false);
        }
        else {
            itemView = inflater.inflate(R.layout.cell_normal,parent,false);
        }
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Word word = allWords.get(position);
        holder.mTextViewNumber.setText(String.valueOf(position + 1));
        holder.mTextViewChinese.setText(word.getChineseMeaning());
        holder.mTextViewEnglish.setText(word.getWord());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://m.youdao.com/dict?le=eng&q=" + holder.mTextViewEnglish.getText());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allWords.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewNumber,mTextViewEnglish,mTextViewChinese;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewNumber = itemView.findViewById(R.id.textViewNumber);
            mTextViewEnglish = itemView.findViewById(R.id.textViewEnglish);
            mTextViewChinese = itemView.findViewById(R.id.textViewChinese);
        }
    }
}
