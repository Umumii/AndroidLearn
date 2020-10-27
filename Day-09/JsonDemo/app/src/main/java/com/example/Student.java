package com.example;

/*
 * JsonDemo
 * Student
 *
 * Created by Tianta on 2020/09/14.
 * Copyright (c) 2020 甜塔. All rights reserved.
 * Describe: xxx.
 */

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("student_name")
    private String name;
    @SerializedName("student_age")
    private int age;
    //transient 忽略不处理@标识
    private Score score;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, Score score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}

class Score {
    private int math;
    private int chinese;
    private int english;

    public Score(int math, int chinese, int english) {
        this.math = math;
        this.chinese = chinese;
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }
}
