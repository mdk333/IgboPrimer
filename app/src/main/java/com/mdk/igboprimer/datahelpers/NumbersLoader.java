/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.datahelpers;

import android.content.Context;

import com.mdk.igboprimer.R;

import java.util.ArrayList;

/**
 * Created by Maduka Attamah on 06/02/2017.
 */

public class NumbersLoader extends WordsLoader {

    public NumbersLoader(Context context) {
        super(context);
    }


    /**
     * Loads the Number objects, tapping from whatever source we choose. All done apart from the UI
     * thread, that is, in the background.
     * @return
     */

    @Override
    public ArrayList<Word> loadInBackground() {
        /*
        *   We create the words here,
        *   BUT!!!  We could also stream this from the web also
        *
        */
        ArrayList<Word> numberWords = new ArrayList<>();
        numberWords.add(new Word(context.getString(R.string.one), context.getString(R.string.oneTranslation), R.raw.igboprimer_audio_number_one, R.drawable.igboprimer_number_one));
        numberWords.add(new Word(context.getString(R.string.two), context.getString(R.string.twoTranslation), R.raw.igboprimer_audio_number_two, R.drawable.igboprimer_number_two));
        numberWords.add(new Word(context.getString(R.string.three), context.getString(R.string.threeTranslation), R.raw.igboprimer_audio_number_three, R.drawable.igboprimer_number_three));
        numberWords.add(new Word(context.getString(R.string.four), context.getString(R.string.fourTranslation), R.raw.igboprimer_audio_number_four, R.drawable.igboprimer_number_four));
        numberWords.add(new Word(context.getString(R.string.five), context.getString(R.string.fiveTranslation), R.raw.igboprimer_audio_number_five, R.drawable.igboprimer_number_five));
        numberWords.add(new Word(context.getString(R.string.six), context.getString(R.string.sixTranslation), R.raw.igboprimer_audio_number_six, R.drawable.igboprimer_number_six));
        numberWords.add(new Word(context.getString(R.string.seven), context.getString(R.string.sevenTranslation), R.raw.igboprimer_audio_number_seven, R.drawable.igboprimer_number_seven));
        numberWords.add(new Word(context.getString(R.string.eight), context.getString(R.string.eightTranslation), R.raw.igboprimer_audio_number_eight, R.drawable.igboprimer_number_eight));
        numberWords.add(new Word(context.getString(R.string.nine), context.getString(R.string.nineTranslation), R.raw.igboprimer_audio_number_nine, R.drawable.igboprimer_number_nine));
        numberWords.add(new Word(context.getString(R.string.ten), context.getString(R.string.tenTranslation), R.raw.igboprimer_audio_number_ten, R.drawable.igboprimer_number_ten));

        return numberWords;
    }
}
