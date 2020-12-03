package day_three;

import aocUtils.FileReader;
import java.util.Vector;

public class Main{
    private Vector<String> fileContent;
    private long treeCounterMultiply = 1;

    public static void main(String[] args){
        Main main = new Main();
        main.startProcess();
    }

    private void startProcess(){
        FileReader fileReader = new FileReader("files/treeMap.txt");
        fileContent = fileReader.readFile();
        for(int i = 1; i < 8;i = i+2){
            getTrees(i,1);
        }
        getTrees(1,2);
        System.out.println(treeCounterMultiply);
    }

    private void getTrees(int moveX, int moveY){
        int treeCounter = 0;
        int currentXPosition = 0;
        for(int i = 0; i < fileContent.size();i += moveY){
            if(fileContent.get(i).charAt(currentXPosition) == '#') treeCounter++;
            currentXPosition += moveX;
            if(currentXPosition >= fileContent.get(0).length()) currentXPosition -= fileContent.get(0).length();
        }
        treeCounterMultiply *= treeCounter;
        System.out.println(treeCounter);
    }

}
