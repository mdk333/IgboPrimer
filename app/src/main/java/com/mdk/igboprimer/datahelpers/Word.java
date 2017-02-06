/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.datahelpers;

/**
 * Created by Maduka Attamah on 03/02/2017.
 */

public class Word {

    private String igboWord;
    private String translation;
    private int wordPronounciationFile = -1;  //Default.
    private int wordImageFile = -1;

    public Word(String igboWord, String translation, int pronounciation, int image) {
        this.igboWord = igboWord;
        this.translation = translation;
        this.wordPronounciationFile = pronounciation;
        this.wordImageFile = image;
    }

    /**
     * For words that don't have a define image, such as some common phrases.
     *
     * @param igboWord
     * @param translation
     * @param pronounciation
     */
    public Word(String igboWord, String translation, int pronounciation) {
        this.igboWord = igboWord;
        this.translation = translation;
        this.wordPronounciationFile = pronounciation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Word{");
        sb.append("igboWord='").append(igboWord).append('\'');
        sb.append(", translation='").append(translation).append('\'');
        sb.append(", wordPronounciationFile=").append(wordPronounciationFile);
        sb.append(", wordImageFile=").append(wordImageFile);
        sb.append('}');
        return sb.toString();
    }

    public String getIgboWord() {
        return igboWord;
    }

    public void setIgboWord(String igboWord) {
        this.igboWord = igboWord;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getWordPronounciationFile() {
        return wordPronounciationFile;
    }

    public void setWordPronounciationFile(int wordPronounciationFile) {
        this.wordPronounciationFile = wordPronounciationFile;
    }

    public int getWordImageFile() {
        return wordImageFile;
    }

    public void setWordImageFile(int wordImageFile) {
        this.wordImageFile = wordImageFile;
    }

}
