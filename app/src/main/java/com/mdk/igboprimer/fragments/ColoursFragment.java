/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.fragments;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mdk.igboprimer.R;
import com.mdk.igboprimer.datahelpers.ColoursLoader;
import com.mdk.igboprimer.datahelpers.Word;
import com.mdk.igboprimer.datahelpers.WordArrayAdapter;
import com.mdk.igboprimer.uihelpers.IgboPrimerOnAudioFocusChangeListener;
import com.mdk.igboprimer.uihelpers.IgboPrimerOnItemClickListener;
import com.mdk.igboprimer.uihelpers.IgboPrimerUtilInterface;

import java.util.ArrayList;

/**
 * Created by Maduka Attamah on 03/02/2017.
 */
public class ColoursFragment extends Fragment implements IgboPrimerUtilInterface,
        LoaderManager.LoaderCallbacks<ArrayList<Word>> {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private WordArrayAdapter wordArrayAdapter;

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


    public ColoursFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View fragmentView = inflater.inflate(R.layout.fragment_colours, container, false);

        // Note that we do not supply data source directly here, the loader will load the data in the background.
        wordArrayAdapter = new WordArrayAdapter(fragmentView.getContext(), R.layout.list_item, R.color.coloursCategory);
        final ListView listView = (ListView) fragmentView.findViewById(R.id.coloursList);
        listView.setAdapter(wordArrayAdapter);

        //Handle the clicking of a list item and playing of the corresponding sound.
        listView.setOnItemClickListener(onItemClickListener);

        // Get a loader ready - an already existing one or a new one.
        getLoaderManager().initLoader(0, null, this);
        return fragmentView;

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
        return wordArrayAdapter.getData();
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

    @Override
    public Loader<ArrayList<Word>> onCreateLoader(int id, Bundle args) {
        // Called when a new loader needs to be created. The main activity is its context.
        return new ColoursLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Word>> loader, ArrayList<Word> data) {
        // Set the data for the adapter when it finishes loading.
        wordArrayAdapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Word>> loader) {
        wordArrayAdapter.setData(null);
    }
}
