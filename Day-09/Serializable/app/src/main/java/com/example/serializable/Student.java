package com.example.serializable;

/*
 * Serializable
 * Student
 *
 * Created by x on 2020/09/14.
 * Copyright (c) 2020 甜塔. All rights reserved.
 * Describe: xxx.
 */

import java.io.Serializable;

/**
 * @author Tianta
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 3165548301895739176L;
    // transient暂时不用序列化
    private String name;
    private int age;
    private Score mScore;

    public Student(String name, int age, Score score) {
        this.name = name;
        this.age = age;
        mScore = score;
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
        return mScore;
    }

    public void setScore(Score score) {
        mScore = score;
    }
}

class Score implements Serializable {
    private static final long serialVersionUID = 890150913833791039L;
    private int math;
    private int chinese;
    private int english;
    private String grade;

    public Score(int math, int chinese, int english) {
        this.math = math;
        this.chinese = chinese;
        this.english = english;
        if (math >= 90 && chinese >= 90 && english >= 90) {
            this.grade = "A";
        } else if (math >= 80 && chinese >= 80 && english >= 80) {
            this.grade = "B";
        } else if (math <= 60 && chinese <= 60 && english <= 60) {
            this.grade = "D";
        } else {
            this.grade = "C";
        }
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
