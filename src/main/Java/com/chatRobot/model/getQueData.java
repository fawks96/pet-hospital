package com.chatRobot.model;
import com.chatRobot.model.QuestionInfo;
import java.util.*;
public class getQueData {

    private List<String> CategoryList;
    int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setCategoryList(List<String> categoryList) {
        CategoryList = categoryList;
    }

    public List<String> getCategoryList() {
        return CategoryList;
    }
}
