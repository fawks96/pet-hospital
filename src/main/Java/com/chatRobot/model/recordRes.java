package com.chatRobot.model;

public class recordRes {

    private String stem;
    private String A;
    private String B;
    private String C;
    private String D;
    private String choice;
    private String TorF;

    public void setTorF(String torF) {
        TorF = torF;
    }

    public String getTorF() {
        return TorF;
    }


    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getA() {
        return A;
    }

    public String getB() {
        return B;
    }

    public String getC() {
        return C;
    }

    public String getD() {
        return D;
    }

    public String getStem() {
        return stem;
    }

    public void setA(String a) {
        A = a;
    }

    public void setB(String b) {
        B = b;
    }

    public void setC(String c) {
        C = c;
    }

    public void setD(String d) {
        D = d;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }
}
