package day_eight;

import aocUtils.FileReader;
import java.util.*;

public class Game{
    
    private Vector<String> fileContent;
    

    public static void main(String[] args){
        Game main = new Game();
        main.startProcess();
    }

    private void startProcess(){
        FileReader fileReader = new FileReader("files/instructions.txt");
        fileContent = fileReader.readFile();
        System.out.println(fileContent.size());
        executeInstructions(0,true);
        findWrongInstruction();
        executeInstructions(0,true);
    }

    private Boolean executeInstructions(int startNumber,Boolean verbose){
        int pointsCounter = 0;
        String[] splittedInstruction;
        ArrayList<Integer> executedInstructions = new ArrayList<Integer>();
        System.out.println("Start Line: " + startNumber);
        int i = startNumber;
        for(; i < fileContent.size();i++){
            if(executedInstructions.contains(i)) break;
            executedInstructions.add(i);
            splittedInstruction = fileContent.get(i).split(" ");
            Integer instructionNumber = (Integer.parseInt(splittedInstruction[1]));
            switch(splittedInstruction[0]){
                case "acc": pointsCounter += instructionNumber;break;
                case "jmp": i += instructionNumber - 1;break;
            }
        }
        System.out.println(i);
        if(verbose) System.out.println(pointsCounter);
        return (i == fileContent.size());
    }

    private void findWrongInstruction(){
        Boolean needsTesting = true,bootSuccessful = false;
        String[] splittedInstruction;
        String changingInstruction = "";
        String oldLine = "";
        for(int i = 0;i < fileContent.size();i++){
            oldLine = fileContent.get(i);
            splittedInstruction = fileContent.get(i).split(" ");
            Integer instructionNumber = Integer.parseInt(splittedInstruction[1]);
            switch(splittedInstruction[0]){
                case "nop": changingInstruction = "jmp " + splittedInstruction[1];break;
                case "jmp": changingInstruction = "nop " + splittedInstruction[1];break;
                default: needsTesting = false;break;
            }
            if(needsTesting){
                fileContent.set(i,changingInstruction); 
                bootSuccessful = executeInstructions(0,false);
                if(bootSuccessful){
                    System.out.println("Changed instruction at " + i + "to " + changingInstruction);
                    return;
                }else{
                    fileContent.set(i,oldLine);
                }
            }
            if(splittedInstruction[0] == "jmp") i += instructionNumber -1;
            needsTesting = true;
        } 
    }
}
