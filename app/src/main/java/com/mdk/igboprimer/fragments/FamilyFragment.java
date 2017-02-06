/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.fragments;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mdk.igboprimer.R;
import com.mdk.igboprimer.datahelpers.Word;
import com.mdk.igboprimer.datahelpers.WordArrayAdapter;
import com.mdk.igboprimer.uihelpers.IgboPrimerOnAudioFocusChangeListener;
import com.mdk.igboprimer.uihelpers.IgboPrimerOnItemClickListener;
import com.mdk.igboprimer.uihelpers.IgboPrimerUtilInterface;

import java.util.ArrayList;

/**
 * Created by Maduka Attamah on 03/02/2017.
 */

public class FamilyFragment extends Fragment implements IgboPrimerUtilInterface {
    private ArrayList<Word> words;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    // Create handler to handle changes in audio focus. Our app should be a good tenant.
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new IgboPrimerOnAudioFocusChangeListener(this);

    // Create a handler to handle click event on list items.
    private AdapterView.OnItemClickListener onItemClickListener = new IgboPrimerOnItemClickListener(this);

    // Create event handler to track when the media file has reached its end and then free resources held by the media player.
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public FamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_family, container, false);

        /*
        *   I do not forsee that we would eventually need a loader here like in the other categories.
        *   The potential size of the dataset is small. Therefore, I just have a little method here that
        *   populates the arraylist of family-member words for me.
        */
        loadFamilyMemberWords();

        // Now create the wordArrayAdapter with the populated arraylist of words and continue as before.
        WordArrayAdapter wordArrayAdapter = new WordArrayAdapter(fragmentView.getContext(), R.layout.list_item, words, R.color.familyMembersCategory);
        final ListView listView = (ListView) fragmentView.findViewById(R.id.familyMembersList);
        listView.setAdapter(wordArrayAdapter);

        //Handle the clicking of a list item and playing of the corresponding sound.
        listView.setOnItemClickListener(onItemClickListener);
        return fragmentView;

    }

    private void loadFamilyMemberWords() {
        if (words == null) {
            words = new ArrayList<>();
        }
        if (words.isEmpty()) {
            words.add(new Word(getString(R.string.father), getString(R.string.fatherTranslation), R.raw.igboprimer_audio_family_father, R.drawable.igboprimer_familymember_father));
            words.add(new Word(getString(R.string.mother), getString(R.string.motherTranslation), R.raw.igboprimer_audio_family_mother, R.drawable.igboprimer_familymember_mother));
            words.add(new Word(getString(R.string.daughter), getString(R.string.daughterTranslation), R.raw.igboprimer_audio_family_daughter, R.drawable.igboprimer_familymember_daughter));
            words.add(new Word(getString(R.string.son), getString(R.string.sonTranslation), R.raw.igboprimer_audio_family_son, R.drawable.igboprimer_familymember_son));
            words.add(new Word(getString(R.string.grandfather), getString(R.string.grandfatherTranslation), R.raw.igboprimer_audio_family_grandfather, R.drawable.igboprimer_familymember_grandfather));
            words.add(new Word(getString(R.string.grandmother), getString(R.string.grandmotherTranslation), R.raw.igboprimer_audio_family_grandmother, R.drawable.igboprimer_familymember_grandmother));
            words.add(new Word(getString(R.string.olderBrother), getString(R.string.olderBrotherTranslation), R.raw.igboprimer_audio_family_older_brother, R.drawable.igboprimer_familymember_older_brother));
            words.add(new Word(getString(R.string.olderSister), getString(R.string.olderSisterTranslation), R.raw.igboprimer_audio_family_older_sister, R.drawable.igboprimer_familymember_older_sister));
            words.add(new Word(getString(R.string.youngerBrother), getString(R.string.youngerBrotherTranslation), R.raw.igboprimer_audio_family_younger_brother, R.drawable.igboprimer_familymember_younger_brother));
            words.add(new Word(getString(R.string.youngerSister), getString(R.string.youngerSisterTranslation), R.raw.igboprimer_audio_family_younger_sister, R.drawable.igboprimer_familymember_younger_sister));
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        //Release the media player resources when the activity is stopped.
        releaseMediaPlayer();
    }


    // Utility method to release resources held by the media player, and also to relinquish audio focus so that
    // other apps can easily grab audio focus.
    @Override
    public void releaseMediaPlayer() {
        //If mediaPlayer is not null, then perharps it is playing some audio.
        if (this.mediaPlayer != null) {
            this.mediaPlayer.release();
            mediaPlayer = null;

            //Now abandon audio focus so that another application can use it.
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    @Override
    public MediaPlayer getMediaPlayer() {
        return this.mediaPlayer;
    }

    @Override
    public ArrayList<Word> getWords() {
        return words;
    }

    @Override
    public AudioManager getAudioManager() {
        return audioManager;
    }

    @Override
    public AudioManager.OnAudioFocusChangeListener getOnAudioFocusChangeListener() {
        return onAudioFocusChangeListener;
    }

    @Override
    public MediaPlayer.OnCompletionListener getOnCompletionListener() {
        return onCompletionListener;
    }

    @Override
    public void setAudioManager(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    @Override
    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}