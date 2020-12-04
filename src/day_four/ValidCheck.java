package day_four;

import aocUtils.FileReader;
import java.util.Vector;

public class ValidCheck{
    private Vector<String> fileLines;
    private String[] checkKeywords = {"byr","iyr","eyr","hgt","hcl","ecl","pid"};
    
    public static void main(String[] args){
        ValidCheck mainChecker = new ValidCheck();
        mainChecker.startCheck();
    }

    private void startCheck(){
        FileReader fileReader = new FileReader("files/passportCheck.txt");
        fileLines = fileReader.readFile();
        checkLines();
    }

    private void checkLines(){
        String currentLinesBuffer = "";
        int validCounter = 0;
        for(int i = 0; i < fileLines.size();i++){
            if(fileLines.get(i).isEmpty()){
                if(checkCurrentBuffer(currentLinesBuffer)){
                    validCounter++;
                }
                currentLinesBuffer = "";
            }else{
                currentLinesBuffer += (" " + fileLines.get(i).replace(":"," "));
            } 
        }
        System.out.println(validCounter);
    }

    private Boolean checkCurrentBuffer(String currentLinesBuffer){
        System.out.println(currentLinesBuffer);
        for(int i = 0; i < checkKeywords.length;i++){
            if(!currentLinesBuffer.contains(checkKeywords[i])){
                return false;
            }
        }
        return true;
    }

}
