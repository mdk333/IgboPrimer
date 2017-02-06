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

public class PhrasesLoader extends WordsLoader {

    public PhrasesLoader(Context context) {
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
        *
        */
        ArrayList<Word> phraseWords = new ArrayList<>();
        phraseWords.add(new Word(context.getString(R.string.comeHere), context.getString(R.string.comeHereTranslation), R.raw.igboprimer_audio_phrase_come));
        phraseWords.add(new Word(context.getString(R.string.yes), context.getString(R.string.yesTranslation), R.raw.igboprimer_audio_phrase_yes));
        phraseWords.add(new Word(context.getString(R.string.no), context.getString(R.string.noTranslation), R.raw.igboprimer_audio_phrase_no));
        phraseWords.add(new Word(context.getString(R.string.howAreYou), context.getString(R.string.howAreYouTranslation), R.raw.igboprimer_audio_phrase_how_are_you));
        phraseWords.add(new Word(context.getString(R.string.goodMorning), context.getString(R.string.goodMorningTranslation), R.raw.igboprimer_audio_phrase_good_morning));
        phraseWords.add(new Word(context.getString(R.string.wellDone), context.getString(R.string.wellDoneTranslation), R.raw.igboprimer_audio_phrase_well_done));
        phraseWords.add(new Word(context.getString(R.string.thankYou), context.getString(R.string.thankYouTranslation), R.raw.igboprimer_audio_phrase_thank_you));
        phraseWords.add(new Word(context.getString(R.string.itIsWell), context.getString(R.string.itIsWellTranslation), R.raw.igboprimer_audio_phrase_it_is_well));
        phraseWords.add(new Word(context.getString(R.string.wait), context.getString(R.string.waitTranslation), R.raw.igboprimer_audio_phrase_wait));
        phraseWords.add(new Word(context.getString(R.string.peace), context.getString(R.string.peaceTranslation), R.raw.igboprimer_audio_phrase_peace));

        return phraseWords;
    }
}
