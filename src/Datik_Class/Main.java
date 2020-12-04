package Datik_Class;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Student nika = new Student(50, "nika", "dularidze", 45.5);

        System.out.println("age: " + nika.age + " name: " + nika.name + " surname: " + nika.surName + " average: " + nika.average);

    }
}

class Student{
    String name;
    String surName;
    int age;
    double average;

    Student(int age, String name, String surName, double average){
        this.age = age;
        this.name = name;
        this.surName = surName;
        this.average = average;
    }
}


class Person{
    String name;
    int age;
    Robot robot;


    Person(String name, int age, String robotName, String robotColor){
        this.name = name;
        this.age = age;
        robot = new Robot(robotName, robotColor);
    }


}

class Robot {
    String name;
    String color;

    Robot (){
        name = "Robo";
        color = "Witeli";
        System.out.println();
    }

    Robot (String name){
        this.name = name;
        color = "Witeli";
    }

    Robot (String name, String color){
        this.name = name;
        this.color = color;
    }

    void CharAt(){
        System.out.println("Roboti saxelad " + this.name + " Gvesalmeba");
    }

    int multiplyByTwo(int a){
        return a * 2;
    }

}
