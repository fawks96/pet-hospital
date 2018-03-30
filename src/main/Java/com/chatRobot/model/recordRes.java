package com.chatRobot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class recordRes {

    private String stem;
    private String A;
    private String B;
    private String C;
    private String D;
    private String choice;
    private String TorF;

    public void setTorF(String TorF) {
        this.TorF = TorF;
    }

    @JsonProperty("TorF")
    public String getTorF() {
        return TorF;
    }


    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @JsonProperty("A")
    public String getA() {
        return A;
    }

    @JsonProperty("B")
    public String getB() {
        return B;
    }

    @JsonProperty("C")
    public String getC() {
        return C;
    }

    @JsonProperty("D")
    public String getD() {
        return D;
    }

    public String getStem() {
        return stem;
    }

    public void setA(String A) {
        this.A = A;
    }


    public void setB(String B) {
        this.B = B;
    }


    public void setC(String C) {
        this.C = C;
    }

    public void setD(String D) {
        this.D = D;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }
}
