/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.uihelpers;

import android.media.AudioManager;

/**
 * Created by Maduka Attamah on 05/02/2017.
 */
public class IgboPrimerOnAudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {

    IgboPrimerUtilInterface fragmentUtilities;

    public IgboPrimerOnAudioFocusChangeListener(IgboPrimerUtilInterface utilities) {
        this.fragmentUtilities = utilities;
    }

    @Override
    public void onAudioFocusChange(int newState) {
        if (newState == AudioManager.AUDIOFOCUS_GAIN) {
            //Start playback.
            fragmentUtilities.getMediaPlayer().start();
        } else if (newState == AudioManager.AUDIOFOCUS_LOSS) {
            // Loss of focus for a long while, say music is playing: release media player resource.
            fragmentUtilities.releaseMediaPlayer();
        } else if (newState == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                newState == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
            // CAN_DUCK means that we (the looser of the audio focus) can choose to duck the playback when this event happens - that is, lower the volume slightly but keep playing in background.
            // Loss of focus for a short while, say phone is ringing: pause playback.
            fragmentUtilities.getMediaPlayer().pause();
            fragmentUtilities.getMediaPlayer().seekTo(0);  //Will start from beginning when playback resumes.
        }
    }
}
