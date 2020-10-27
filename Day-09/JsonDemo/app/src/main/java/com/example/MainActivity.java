package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        objectToJson();
//        jsonToObject();
//        ObjectSubToJson();
//        jsonToObjectSub();
//        objectsToJson();
//        jsonToObjects();
//        objectListToJson();
//        jsonToObjectList();

        Student student = new Student("Tom", 13, new Score(85,90,85));
        Gson gson = new Gson();
        String json = gson.toJson(student);
        Log.d("myTag", json);
    }

    public void objectToJson() {
        Student student = new Student("Tom", 13);
        Gson gson = new Gson();
        String json = gson.toJson(student);
        Log.d("myTag", json);
    }

    public void jsonToObject() {
        String json = "{\"age\":13,\"name\":\"Tom\"}";
        Gson gson = new Gson();
        Student student = gson.fromJson(json,Student.class);
        Log.d("myTag", student.getName());
    }

    public void ObjectSubToJson() {
        Student student = new Student("Tom", 13, new Score(85,90,85));
        Gson gson = new Gson();
        String json = gson.toJson(student);
        Log.d("myTag", json);
    }

    public void jsonToObjectSub() {
        String json = "{\n" +
                "  \"age\": 13,\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"score\": {\n" +
                "    \"chinese\": 90,\n" +
                "    \"english\": 85,\n" +
                "    \"math\": 85\n" +
                "  }\n" +
                "}";
        Gson gson = new Gson();
        Student student = gson.fromJson(json,Student.class);
        Log.d("myTag", student.getName());
    }

    public void objectsToJson() {
        Gson gson = new Gson();
        Student student1 = new Student("Mike",25,new Score(85,65,95));
        Student student2 = new Student("Tom",12,new Score(75,80,90));
        Student student3 = new Student("Jack ",20,new Score(60,65,69));

        Student[] students = {student1,student2,student3};
        String json = gson.toJson(students);
        Log.d("myTag",json);
    }

    public void jsonToObjects() {
        Gson gson = new Gson();


        String json = "[\n" +
                "        {\n" +
                "            \"age\": 25,\n" +
                "                \"name\": \"Mike\",\n" +
                "                \"score\": {\n" +
                "            \"chinese\": 65,\n" +
                "                    \"english\": 95,\n" +
                "                    \"math\": 85\n" +
                "        }\n" +
                "        },\n" +
                "        {\n" +
                "            \"age\": 12,\n" +
                "                \"name\": \"Tom\",\n" +
                "                \"score\": {\n" +
                "            \"chinese\": 80,\n" +
                "                    \"english\": 90,\n" +
                "                    \"math\": 75\n" +
                "        }\n" +
                "        },\n" +
                "        {\n" +
                "            \"age\": 20,\n" +
                "                \"name\": \"Jack \",\n" +
                "                \"score\": {\n" +
                "            \"chinese\": 65,\n" +
                "                    \"english\": 69,\n" +
                "                    \"math\": 60\n" +
                "        }\n" +
                "        }\n" +
                "]";
        Student[] students = gson.fromJson(json,Student[].class);
        Log.d("myTag", students[0].getName());
    }

    public void objectListToJson() {
        Gson gson = new Gson();
        Student student1 = new Student("Mike",25,new Score(85,65,95));
        Student student2 = new Student("Tom",12,new Score(75,80,90));
        Student student3 = new Student("Jack ",20,new Score(60,65,69));

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        String json = gson.toJson(list);
        Log.d("myTag",json);
    }

    public void jsonToObjectList() {
        Gson gson = new Gson();


        String json = "[\n" +
                "        {\n" +
                "            \"age\": 25,\n" +
                "                \"name\": \"Mike\",\n" +
                "                \"score\": {\n" +
                "            \"chinese\": 65,\n" +
                "                    \"english\": 95,\n" +
                "                    \"math\": 85\n" +
                "        }\n" +
                "        },\n" +
                "        {\n" +
                "            \"age\": 12,\n" +
                "                \"name\": \"Tom\",\n" +
                "                \"score\": {\n" +
                "            \"chinese\": 80,\n" +
                "                    \"english\": 90,\n" +
                "                    \"math\": 75\n" +
                "        }\n" +
                "        },\n" +
                "        {\n" +
                "            \"age\": 20,\n" +
                "                \"name\": \"Jack \",\n" +
                "                \"score\": {\n" +
                "            \"chinese\": 65,\n" +
                "                    \"english\": 69,\n" +
                "                    \"math\": 60\n" +
                "        }\n" +
                "        }\n" +
                "]";
        Type typeStudents = new TypeToken<List<Student>>(){}.getType();

        List<Student> list = new ArrayList<>();
        list = gson.fromJson(json,typeStudents);
        //students = gson.fromJson(json, List.class);
        Log.d("myTag", list.get(0).getName());
    }
}