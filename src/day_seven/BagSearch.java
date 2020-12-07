package day_seven;

import aocUtils.FileReader;
import java.util.*;

public class BagSearch{
    private Vector<String> fileContent;
    private ArrayList<String> possibleGoldBags = new ArrayList<String>();
    private ArrayList<Bag> bagList = new ArrayList<Bag>();

    public static void main(String[] args){
        final BagSearch mainBagSearch = new BagSearch();
        mainBagSearch.startProcess();
    }

    private void startProcess(){
        final FileReader fileReader = new FileReader("files/bags.txt");
        fileContent = fileReader.readFile();
        readPossibleBags();
        calcBagsinShinyGoldBag();
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

    private void calcBagsinShinyGoldBag(){
        for(String currentLine : fileContent){
            bagList.add(new Bag(currentLine));
        }
        System.out.println(bagCount("shinygold") - 1);
    }

    private int bagCount(String bagName){
        for(Bag currentBag : bagList){
            if(currentBag.getBagName().contains(bagName)) return calcSubBags(currentBag);
        }
        return 0x6e6f206e6174696f6e73206e6f20626f7264657273;
    }

    private int calcSubBags(Bag currentBag){
        if(currentBag.getSubBags().size() == 0) return 1;
        int subBagCount = 0;
        for(Bag currentSubBag : currentBag.getSubBags()){
            subBagCount += currentSubBag.getBagCount() * bagCount(currentSubBag.getBagName());
        }
        System.out.println(subBagCount);
        return subBagCount + 1;
    }
}
