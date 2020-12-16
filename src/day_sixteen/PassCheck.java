package day_sixteen;

import aocUtils.FileReader;
import java.util.*;

public class PassCheck{
    Vector<String> fileContent;
    ArrayList<PassLimit> passLimits = new ArrayList<PassLimit>();

    public static void main(String[] args){
        PassCheck main = new PassCheck();
        main.startProcess();
    }

    private void startProcess(){
        FileReader fileReader = new FileReader("files/passCheck.txt");
        fileContent = fileReader.readFile();
        calculateErrorCode();
    }

    private void calculateErrorCode(){
        int errorCounter = 0, currentLineCounter = 0;
        while(!fileContent.get(currentLineCounter).trim().isEmpty()){
            createLimitsFromCurrentLine(fileContent.get(currentLineCounter));
            currentLineCounter++;
        }
        currentLineCounter += 5;
        for(;currentLineCounter < fileContent.size();currentLineCounter++){
            errorCounter += checkForInvalidFields(fileContent.get(currentLineCounter));
        }
        System.out.println(errorCounter);
    }

    private void createLimitsFromCurrentLine(String currentLine){
        String[] currentLineSplitted = currentLine.split(" ");
        for(String currentSplit : currentLineSplitted){
            if(currentSplit.contains("-")) passLimits.add(new PassLimit(currentSplit));
        }
    }

    private int checkForInvalidFields(String currentLine){
        String[] splittedForNumbers = currentLine.split(",");
        int currentNumber = 0;
        Boolean numberValid = false;
        for(String currentString : splittedForNumbers){
            currentNumber = Integer.parseInt(currentString); 
            for(PassLimit currentLimit : passLimits){
                if(currentLimit.checkNumber(currentNumber)){
                    numberValid = true;
                    break;
                } 
            }
            if(numberValid == false) return currentNumber;
            numberValid = false;
        }
        return 0;
    }
}
