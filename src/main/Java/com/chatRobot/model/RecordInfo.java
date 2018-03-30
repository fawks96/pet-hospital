package com.chatRobot.model;

import java.io.Serializable;

public class RecordInfo extends RecordInfoKey implements Serializable {
    private String choice;

    private String TorF;

    private static final long serialVersionUID = 1L;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice == null ? null : choice.trim();
    }

    public String getTorF() {
        return TorF;
    }

    public void setTorF(String torF) {
        TorF = torF;
    }
}