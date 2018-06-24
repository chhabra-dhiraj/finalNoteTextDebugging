package com.example.dhirajchhabraeng.homework1;

import java.io.Serializable;

public class Note implements Serializable{
    String timeText = "";
    String titleText = "";
    String noteText = "";

    public Note(String timeText, String titleText) {
        this.timeText = timeText;
        this.titleText = titleText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getTimeText() {
        return timeText;
    }

    public String getTitleText() {
        return titleText;
    }

    public String getNoteText() {
        return noteText;
    }
}
