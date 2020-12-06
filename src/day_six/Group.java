package day_six;

import java.util.*;

public class Group{
    ArrayList<String>answersGiven = new ArrayList<String>();
    Set<String> uniqueAnswers = new HashSet<String>();
    int memberCount = 0;

    public Group(String answers,int memberCount){
        getAnswers(answers);
        this.memberCount = memberCount;
    }

    private void getAnswers(String answers){
        for(char currentLetter : answers.toCharArray()){
            answersGiven.add(String.valueOf(currentLetter));
        }
        uniqueAnswers.addAll(answersGiven);
    }

    public int getAnswerCount(){
        return uniqueAnswers.size();
    }

    public int getGroupAnswerCount(){
        int commonAnswer = 0;
        for(String currentLetter : uniqueAnswers){
            if(Collections.frequency(answersGiven,currentLetter) == memberCount){
                commonAnswer++;
            }
        }
        System.out.println(commonAnswer);
        System.out.println(uniqueAnswers.toString());
        return commonAnswer;
    }

}
