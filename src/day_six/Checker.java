package day_six;

import aocUtils.FileReader;
import java.util.*;

public class Checker{
    private Vector<String> fileContent; 
    private ArrayList<Group> groupAnswers = new ArrayList<Group>();

    public static void main(String[] args){
        Checker main = new Checker();
        main.startProcess();
    }

    private void startProcess(){
        final FileReader fileReader = new FileReader("files/answers.txt");
        fileContent = fileReader.readFile();
        analyzeFile();
        getCount();
    }

    private void analyzeFile(){
        String currentAnswers = "";
        int currentMembersOfGroup = 0;
        for(String currentLine : fileContent){
            if(currentLine.trim().isEmpty()){
                groupAnswers.add(new Group(currentAnswers,currentMembersOfGroup));
                currentAnswers = "";
                currentMembersOfGroup = 0;
            }else{
                currentAnswers += currentLine.trim();
                currentMembersOfGroup++;
            }
        }
    }

    private void getCount(){
        int answerCounter = 0, commonAnserCount = 0;
        for(Group currentGroup: groupAnswers){
            answerCounter += currentGroup.getAnswerCount(); 
            commonAnserCount += currentGroup.getGroupAnswerCount();
        }
            System.out.println(answerCounter + "," + commonAnserCount);
    }
}
