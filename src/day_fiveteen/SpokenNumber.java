package day_fiveteen;

import java.util.*;


public class SpokenNumber{
    private ArrayList<Integer> alreadySpokenNumbers = new ArrayList<Integer>();

    public static void main(String[] args){
        SpokenNumber main = new SpokenNumber();
        main.startProcess();
    }

    private void startProcess(){
        Integer[] startNumbers = {5,1,9,18,13,8,0};
        fillStartArray(startNumbers);
        calculateSpokenNumber(2020);
        calculateSpokenNumber(30000000);
    }

    private void fillStartArray(Integer[] startNumbers){
        for(Integer currentNumber : startNumbers){
            alreadySpokenNumbers.add(currentNumber);
        }
    }

    private void calculateSpokenNumber(int endNumber){
        int currentNumber = alreadySpokenNumbers.get(alreadySpokenNumbers.size()-1);
        for(int i = alreadySpokenNumbers.size(); i < endNumber;i++){
            currentNumber = findCurrentNumberInList(currentNumber);
            alreadySpokenNumbers.add(currentNumber);
        }
        System.out.println(alreadySpokenNumbers.get(alreadySpokenNumbers.size()-1));
    }

    private int findCurrentNumberInList(int compareNumber){
        Integer lastPosition = null,secondLastPosition = null;
        for(int i = 0; i < alreadySpokenNumbers.size();i++){
            if(alreadySpokenNumbers.get(i) == compareNumber){
                secondLastPosition = lastPosition;
                lastPosition = i;
            }
        }
        if(secondLastPosition == null) return 0;
        return lastPosition-secondLastPosition;
    }
}
