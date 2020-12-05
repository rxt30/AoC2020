package day_five;

import java.util.*;
import aocUtils.FileReader;

public class Main{
    private Vector<String> fileContent;
    private Vector<Seat> seatList = new Vector<Seat>();

    public static void main(String[] args){
        Main main = new Main();
        main.startProcess();
    }

    private void startProcess(){
        FileReader fileReader = new FileReader("files/passBoards.txt"); 
        fileContent = fileReader.readFile();
        createSeats();
        getHighestSeat();
    }

    private void createSeats(){
        for(int i = 0; i < fileContent.size();i++){
            seatList.add(new Seat(fileContent.get(i))); 
        }
    }

    private void getHighestSeat(){
        int highestSeatNumber = 0;
        int currentSeatID = 0;
        for(int i = 0; i < seatList.size();i++){
            currentSeatID = seatList.get(i).getSeatID();
            if(currentSeatID > highestSeatNumber) highestSeatNumber = currentSeatID;
        }
        System.out.println(highestSeatNumber);
    }
}
