/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.datahelpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mdk.igboprimer.R;

import java.util.ArrayList;

/**
 * Created by Maduka Attamah on 03/02/2017.
 */

public class WordArrayAdapter extends ArrayAdapter<Word> {

    ArrayList<Word> words;
    int themeColour;

    public WordArrayAdapter(Context context, int resource, ArrayList<Word> data, int themeColour) {
        super(context, resource, data);
        //this.addAll(data);  //super class already add all...
        this.themeColour = themeColour;
    }

    public WordArrayAdapter(Context context, int resource, int themeColour) {
        super(context, resource);
        this.themeColour = themeColour;
        words = new ArrayList<>();
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listViewItem = convertView;
        //If list_view_item is being used for the first time, inflate it.
        if(listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Assign the appropriate word image depending on the position that is requested.
        ImageView imageView = (ImageView) listViewItem.findViewById(R.id.wordImage);
        int imageId = this.getItem(position).getWordImageFile();
        if(imageId == -1) { //Still the default? Then word has no image.
            imageView.setVisibility(ImageView.GONE);
        } else {
            imageView.setImageResource(this.getItem(position).getWordImageFile());
        }

        //Assign appropriate Igbo word.
        TextView igboWordView = (TextView) listViewItem.findViewById(R.id.igboWordView);
        igboWordView.setText(this.getItem(position).getIgboWord());

        //And the corresponding Igbo word translation
        TextView igboWordTranslationView = (TextView) listViewItem.findViewById(R.id.igboWordTranslationView);
        igboWordTranslationView.setText(this.getItem(position).getTranslation());

        //Assign the correct theme colour to the word background.
        LinearLayout wordAreaLayout = (LinearLayout) listViewItem.findViewById(R.id.wordAreaLayout);
        wordAreaLayout.setBackgroundColor(ContextCompat.getColor(getContext(), themeColour));

        //Now return the newly populated list view item.
        return listViewItem;
    }

    /**
     *  Set the data with this method, in the case where the class was constructed without a
     *  words list.
     * @param data
     */
    public void setData(ArrayList<Word> data) {

        if (data != null) {
            clear();
            addAll(data);
            words.clear();
            words.addAll(data);
        }
    }

    public ArrayList<Word> getData() {
        return words;
    }
}
