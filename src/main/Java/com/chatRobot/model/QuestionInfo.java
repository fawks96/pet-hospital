package com.chatRobot.model;

import java.io.Serializable;

public class QuestionInfo implements Serializable {
    private Integer id;

    private String category;

    private String stem;

    private String a;

    private String b;

    private String c;

    private String d;

    private String answer;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem == null ? null : stem.trim();
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a == null ? null : a.trim();
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b == null ? null : b.trim();
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c == null ? null : c.trim();
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d == null ? null : d.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}