package aocUtils;

import java.util.Vector;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader{
    private String inputFile;

    public FileReader(String inputFile){
        this.inputFile = inputFile;
    }

    public Vector<String> readFile(){
        Vector<String> fileContent = new Vector<String>();
        try{
            FileInputStream fileStream = new FileInputStream(inputFile);
            Scanner fileScanner = new Scanner(fileStream);
            while(fileScanner.hasNextLine()){
                fileContent.add(fileScanner.nextLine());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return fileContent;
    }
}
