package day_seven;

import java.util.*;

public class Bag{
    private String bagName;
    private int bagCount;
    private ArrayList<Bag> subBags = new ArrayList<Bag>();
    
    public Bag(String currentLine){
        extractBags(currentLine);
    }

    public Bag(int bagCount,String bagName){
        this.bagCount = bagCount;
        this.bagName = bagName;
    }

    private void extractBags(String currentLine){
        String[] currentLineSplitted = currentLine.split(" ");
        String nextBag = "";
        this.bagName = currentLineSplitted[0] + currentLineSplitted[1];
        for(int i = 4; i < currentLineSplitted.length;i += 4){
            if(currentLineSplitted[i].contains("no") == false){
               nextBag = currentLineSplitted[i+1] + currentLineSplitted[i+2];
               subBags.add(new Bag(Integer.parseInt(currentLineSplitted[i]),nextBag));
            }
        }
    }

    public ArrayList<Bag> getSubBags(){
        return subBags;
    }

    public String getBagName(){
        return bagName;
    }

    public int getBagCount(){
        return bagCount;
    }
}
