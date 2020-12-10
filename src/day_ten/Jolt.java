package day_ten;

import aocUtils.FileReader;
import java.util.*;

public class Jolt{
    private ArrayList<Integer> joints = new ArrayList<Integer>();
    private Vector<String> fileContent;

    public static void main(String[] args){
        Jolt main = new Jolt();
        main.startProcess();
    }

    private void startProcess(){
        FileReader fileReader = new FileReader("files/jolts.txt");
        fileContent = fileReader.readFile();
        sortFileContent();
        calculateJoltDifferences();
    }

    private void sortFileContent(){
       for(String currentLine : fileContent){
            joints.add(Integer.parseInt(currentLine));
       }
       Collections.sort(joints);
    }

    private void calculateJoltDifferences(){
        int currentDifference = 0;
        int singleCounter = 1, trippleCounter = 1;
        for(int i = 0; i < joints.size()-1;i++){
            currentDifference = joints.get(i+1) - joints.get(i);
            switch(currentDifference){
                case 1: singleCounter++;break;
                case 3: trippleCounter++;break;
           }
        }
        System.out.println(singleCounter);
    }

}
