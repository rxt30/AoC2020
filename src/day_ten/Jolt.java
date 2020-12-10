package day_ten;

import aocUtils.FileReader;
import java.util.*;

public class Jolt{
    private ArrayList<Integer> joints = new ArrayList<Integer>();
    private Vector<String> fileContent;
    private int combinationsCounter = 0;

    public static void main(String[] args){
        Jolt main = new Jolt();
        main.startProcess();
    }

    private void startProcess(){
        FileReader fileReader = new FileReader("files/jolts.txt");
        fileContent = fileReader.readFile();
        sortFileContent();
        calculateJoltDifferences();
        findAllCombinations(0);
        System.out.println(combinationsCounter);
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
    
    private void findAllCombinations(int start){
        long[] nodes = new long[joints.size()];
        nodes[0] = 1;
        for(int i = 1; i < joints.size(); i++){
            for(int j = i - 3;j < i; j++){
                if( j >= 0 && joints.get(i) - joints.get(j) <= 3){
                    nodes[i] += nodes[j];
                }
            }
        }
        System.out.println(nodes[nodes.length-1]);
    }

}
