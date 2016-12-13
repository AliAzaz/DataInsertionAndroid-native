package com.example.ali.trialapp;

/**
 * Created by Ali on 12/9/2016.
 */

public class Record {

    //private variables
    int _id;
    String ques;
    String answer;

    // Empty constructor
    public Record(){

    }

    // constructor
    public Record(String name, String answer){
        this.ques = name;
        this.answer = answer;
    }

    // getting name
    public String getQues(){
        return this.ques;
    }


    // getting phone number
    public String getAnswer(){
        return this.answer;
    }
}
