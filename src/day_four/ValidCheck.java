package day_four;

import aocUtils.FileReader;
import java.util.Vector;
import java.util.Arrays;

public class ValidCheck{
    private Vector<String> fileLines;
    private String[] checkKeywords = {"byr","iyr","eyr","hgt","hcl","ecl","pid"};
    private String[] eyeColors = {"amb","blu","brn","gry","grn","hzl","oth"};
    
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
                if(checkCurrentBuffer(currentLinesBuffer.replace(":"," ")) && checkCorrectValues(currentLinesBuffer.split(" "))){
                    validCounter++;
                }
                currentLinesBuffer = "";
            }else{
                currentLinesBuffer += (" " + fileLines.get(i));
            } 
        }
        System.out.println(validCounter);
    }

    private Boolean checkCurrentBuffer(String currentLinesBuffer){
        for(int i = 0; i < checkKeywords.length;i++){
            if(!currentLinesBuffer.contains(checkKeywords[i])){
                return false;
            }
        }
        return true;
    }

    private Boolean checkCorrectValues(String[] splittedValues){
        for(int i = 1; i < splittedValues.length;i++){
            if(checkValuePair(splittedValues[i].split(":")) == false) return false;
        }
        return true;
    }
    
    private Boolean checkValuePair(String[] keyValuePair){
        switch(keyValuePair[0].trim()){
            case "byr": case "iyr": case "eyr": return checkYear(keyValuePair);
            case "hgt": return checkHeight(keyValuePair[1]);
            case "hcl": return keyValuePair[1].matches("#[0-f]{6}");
            case "ecl": return checkEyeColor(keyValuePair[1]);
            case "pid": return (keyValuePair[1].length() == 9);
            case "cid": return true;
        }
        return false;
    }

    private Boolean checkYear(String[] checkYear){
        int year = Integer.parseInt(checkYear[1]);
        switch(checkYear[0].trim()){
            case "byr": return (1920 <= year && year <= 2002);
            case "iyr": return (2010 <= year && year <= 2020);
            case "eyr": return (2020 <= year && year <= 2030);
        }
        return false;
    }

    private Boolean checkHeight(String height){
        if(height.contains("cm")){
            int measurement = Integer.parseInt(height.split("c")[0]);
            return (150 <= measurement && measurement <= 193);
        }else if(height.contains("in")){
            int measurement = Integer.parseInt(height.split("i")[0]);
            return (59 <= measurement && measurement <= 76);
        }
        return false;
    }

    private Boolean checkEyeColor(String eyeColor){
       for(int i = 0; i < eyeColors.length; i++){
            if(eyeColors[i].contains(eyeColor)) {
                System.out.println(eyeColor);
                return true;
            }
       } 
       return false;
    }
}
