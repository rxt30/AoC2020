package day_seven;

import aocUtils.FileReader;
import java.util.*;

public class BagSearch{
    private Vector<String> fileContent;
    private ArrayList<String> possibleGoldBags = new ArrayList<String>();

    public static void main(String[] args){
        final BagSearch mainBagSearch = new BagSearch();
        mainBagSearch.startProcess();
    }

    private void startProcess(){
        final FileReader fileReader = new FileReader("files/bags.txt");
        fileContent = fileReader.readFile();
        readPossibleBags();
    }

    private void readPossibleBags(){
        int oldSize = 1;
        while(oldSize != possibleGoldBags.size()){
            oldSize = possibleGoldBags.size();
            for(String currentLine : fileContent){
                searchLineForGold(currentLine);     
            }
        }
        System.out.println(possibleGoldBags.size());
    }

    private Boolean searchLineForGold(String currentLine){
        String[] lineSplitted = currentLine.split(" ");
        String currentBag = lineSplitted[0] + lineSplitted[1];
        if(goldFoundInBag(lineSplitted) && (possibleGoldBags.contains(currentBag) == false)){
            possibleGoldBags.add(currentBag);
            return true;
        }
        return false;
    }

    private Boolean goldFoundInBag(String[] splittedLine){
        String currentBag = "";
        for(int i = 5; i < splittedLine.length;i += 4){
            currentBag = splittedLine[i].trim() + splittedLine[i+1];
            if(possibleGoldBags.contains(currentBag) || currentBag.contains("shinygold")) return true;
        }
        return false;
    }
}
