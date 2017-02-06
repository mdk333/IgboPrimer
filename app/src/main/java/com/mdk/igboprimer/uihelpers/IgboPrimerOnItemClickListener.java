/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.uihelpers;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Maduka Attamah on 05/02/2017.
 */
public class IgboPrimerOnItemClickListener implements AdapterView.OnItemClickListener {
    private IgboPrimerUtilInterface fragmentUtilities;

    public IgboPrimerOnItemClickListener(IgboPrimerUtilInterface fragmentUtilities) {
        this.fragmentUtilities = fragmentUtilities;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        AudioManager audioManager = (AudioManager) ((Fragment)fragmentUtilities).getActivity().getSystemService(Context.AUDIO_SERVICE);
        fragmentUtilities.setAudioManager(audioManager);

        // Release the current instance of media player, we are about to play a different sound. Alternatively, we
        // could stop it first, then assign a different sound source to it.
        fragmentUtilities.releaseMediaPlayer();

        // We use the audioManager object to request audio focus for our activity. This same
        // audioManager maintains also the audioFocus Changer Listener that listens to changes
        // in audio focus once our audio file starts playing. So the audiofocus manager knows what
        // to do if our activity were to loose audio focus temporarily or permanently during playback,
        // and also what to do if our activity gains audioFocus after loosing it while playing an audio file.
        int result = fragmentUtilities.getAudioManager().requestAudioFocus(fragmentUtilities.getOnAudioFocusChangeListener(),
                AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            // We've got audio focus now so we can create our media player and start playing the sound.
            MediaPlayer mediaPlayer = MediaPlayer.create(((Fragment)fragmentUtilities).getActivity(), fragmentUtilities.getWords().get(position).getWordPronounciationFile());
            fragmentUtilities.setMediaPlayer(mediaPlayer);
            fragmentUtilities.getMediaPlayer().start();

            // Set on completion listener so that we can release the media player when we reach the end of the sound file.
            fragmentUtilities.getMediaPlayer().setOnCompletionListener(fragmentUtilities.getOnCompletionListener());
        }
    }
}
