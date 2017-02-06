/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.datahelpers;

import android.content.Context;

import java.util.ArrayList;

import com.mdk.igboprimer.R;

/**
 * Created by Maduka Attamah on 05/02/2017.
 */

public class ColoursLoader extends WordsLoader {

    public ColoursLoader(Context context) {
        super(context);
    }

    /**
     * Loads the colour objects, tapping from whatever source we choose. All done apart from the UI
     * thread, that is, in the background.
     * @return
     */
    @Override
    public ArrayList<Word> loadInBackground() {
        /*
        *   We create the words here,
        *   BUT!!!  We could also stream this from the web also
        *   BUT!!! Monday.
        */
        ArrayList<Word> colourWords = new ArrayList<>();
        colourWords.add(new Word(context.getString(R.string.red), context.getString(R.string.redTranslation), R.raw.igboprimer_audio_colour_red, R.drawable.igboprimer_colour_red));
        colourWords.add(new Word(context.getString(R.string.yellow), context.getString(R.string.yellowTranslation), R.raw.igboprimer_audio_colour_yellow, R.drawable.igboprimer_colour_yellow));
        colourWords.add(new Word(context.getString(R.string.dustyYellow), context.getString(R.string.dustyYellowTranslation), R.raw.igboprimer_audio_colour_dusty_yellow, R.drawable.igboprimer_colour_dusty_yellow));
        colourWords.add(new Word(context.getString(R.string.green), context.getString(R.string.greenTranslation), R.raw.igboprimer_audio_colour_green, R.drawable.igboprimer_colour_green));
        colourWords.add(new Word(context.getString(R.string.brown), context.getString(R.string.brownTranslation), R.raw.igboprimer_audio_colour_brown, R.drawable.igboprimer_colour_brown));
        colourWords.add(new Word(context.getString(R.string.gray), context.getString(R.string.grayTranslation), R.raw.igboprimer_audio_colour_gray, R.drawable.igboprimer_colour_gray));
        colourWords.add(new Word(context.getString(R.string.blackColour), context.getString(R.string.blackColourTranslation), R.raw.igboprimer_audio_colour_black, R.drawable.igboprimer_colour_black));
        colourWords.add(new Word(context.getString(R.string.white), context.getString(R.string.whiteTranslation), R.raw.igboprimer_audio_colour_white, R.drawable.igboprimer_colour_white));

        return colourWords;
    }
}
