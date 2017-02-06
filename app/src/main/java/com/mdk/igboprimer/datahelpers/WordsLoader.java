/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.datahelpers;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;

/**
 * Created by Maduka Attamah on 03/02/2017.
 */
/**
 * A custom Loader that loads our words.
 */
public abstract class WordsLoader extends AsyncTaskLoader<ArrayList<Word>> {

    protected ArrayList<Word> words;
    protected Context context;

    public WordsLoader(Context context) {

        super(context);
        this.context = context;
    }

    /**
     * This is where the bulk of our work is done.  This function is
     * called in a background thread and should generate a new set of
     * data to be published by the loader. Will be implemented by sub classes
     * representing each of the word categories to load.
     */

     public abstract ArrayList<Word> loadInBackground();

    /**
     * Called when there is new data to deliver to the client.  The
     * super class will take care of delivering it; the implementation
     * here just adds a little more logic.
     */
    @Override
    public void deliverResult(ArrayList<Word> wordsList) {

        // Refresh our words field.
        if(wordsList != null) {
            words = wordsList;
        }

        if (isStarted()) {
            // If the Loader is currently started, we can immediately
            // deliver its results.
            super.deliverResult(wordsList);
        }
    }

    /**
     * Handles a request to start the Loader.
     */
    @Override
    protected void onStartLoading() {
        if (this.words != null) {
            // If we currently have a result available, deliver it
            // immediately.
            deliverResult(this.words);
        }

        if (takeContentChanged() || this.words == null) {
            // If the data has changed since the last time it was loaded
            // or is not currently available, start a load.
            forceLoad();
        }
    }

    /**
     * Handles a request to stop the Loader.
     */
    @Override
    protected void onStopLoading() {
        // Attempt to cancel the current load task if possible.
        cancelLoad();
    }

    /**
     * Handles a request to cancel a load.
     */
    @Override
    public void onCanceled(ArrayList<Word> wordsList) {
        super.onCanceled(wordsList);

        // At this point we can release the resources associated with 'wordsList'
        // if needed.
        onReleaseResources(wordsList);
    }

    /**
     * Handles a request to completely reset the Loader.
     */
    @Override protected void onReset() {
        super.onReset();

        // Ensure the loader is stopped
        onStopLoading();

        // At this point we can release the resources associated with 'words'
        // if needed.
        if (this.words != null) {
            onReleaseResources(this.words);
        }

    }

    /**
     * Helper function to take care of releasing resources associated
     * with an actively loaded data set.
     */
    protected void onReleaseResources(ArrayList<Word> wordsList) {
        // For a simple ArrayList<> there is nothing much to do.  For something
        // like a Cursor, we would close it here.
        if(wordsList != null) {
            wordsList.clear();
           // wordsList = null;
        }

    }
}