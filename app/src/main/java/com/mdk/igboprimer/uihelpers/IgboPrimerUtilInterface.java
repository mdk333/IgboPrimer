/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.uihelpers;

import android.media.AudioManager;
import android.media.MediaPlayer;

import com.mdk.igboprimer.datahelpers.Word;

import java.util.ArrayList;


/**
 * Created by Maduka Attamah on 05/02/2017.
 */

public interface IgboPrimerUtilInterface {
    /**
     * Gives us the media player object in use by the current fragment.
     *
     * @return media player object.
     */
    MediaPlayer getMediaPlayer();

    /**
     * Gives us the words array in use by the current fragment
     *
     * @return ArrayList of words.
     */
    ArrayList<Word> getWords();

    /**
     * Gives us the audio manager object in use by the current fragment.
     *
     * @return AudioManager object.
     */
    AudioManager getAudioManager();

    /**
     * Gives us the OnAudioFocusChangerListener object in use by the current fragment.
     *
     * @return
     */
    AudioManager.OnAudioFocusChangeListener getOnAudioFocusChangeListener();

    /**
     * Gives us the OnCompletionListener object in use by the current fragment.
     *
     * @return
     */
    MediaPlayer.OnCompletionListener getOnCompletionListener();

    /**
     * Sets the AudioManager object in used by the current fragment.
     *
     * @param audioManager
     */
    void setAudioManager(AudioManager audioManager);

    /**
     * Sets teh MediaPlayer object in use by the current fragment.
     *
     * @param mediaPlayer
     */
    void setMediaPlayer(MediaPlayer mediaPlayer);

    /**
     * Releases media player resources used by the current fragment.
     */
    void releaseMediaPlayer();


}
