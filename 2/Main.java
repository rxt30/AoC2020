import java.util.Vector;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Main{
    private Vector<PasswordObjects> pObjectList = new Vector<PasswordObjects>();


    public static void main(String[] args){
        Main mainProcess = new Main();
        mainProcess.startProcess();
    }

    private void startProcess(){
        readFile();
        getValidPassword();
    }

    private void readFile(){
        try{
            FileInputStream fileStream = new FileInputStream("passwords.txt");
            Scanner fileScanner = new Scanner(fileStream);
            while(fileScanner.hasNextLine()){
                pObjectList.add(new PasswordObjects(fileScanner.nextLine()));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void getValidPassword(){
        int validCounter = 0;
        int validPositionCounter = 0;
        for(int i = 0; i < pObjectList.size();i++){
            if(pObjectList.get(i).passwordValidPosition()) validPositionCounter++;
            if(pObjectList.get(i).passwordValid()) validCounter++;
        }
        System.out.println(validCounter);
        System.out.println(validPositionCounter);
    }
}
