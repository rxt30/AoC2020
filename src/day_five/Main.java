package day_five;

import java.util.*;
import aocUtils.FileReader;


public class Main{
    private Vector<String> fileContent;
    private List<Seat> seatList = new Vector<Seat>();

    public static void main(String[] args){
        Main main = new Main();
        main.startProcess();
    }

    private void startProcess(){
        FileReader fileReader = new FileReader("files/passBoards.txt"); 
        fileContent = fileReader.readFile();
        createSeats();
        getHighestSeat();
        getPersonalSeat();
    }

    private void createSeats(){
        for(int i = 0; i < fileContent.size();i++){
            seatList.add(new Seat(fileContent.get(i))); 
        }
        Comparator<Seat> seatsByID = (Seat seat1, Seat seat2) -> seat1.getSeatID().compareTo(seat2.getSeatID());
        seatList.sort(seatsByID);
    }

    private void getHighestSeat(){
        System.out.println(seatList.get(seatList.size()-1).getSeatID());
    }

    private void getPersonalSeat(){
        for(int i = 0; i < seatList.size() - 1;i++){
            if(seatList.get(i+1).getSeatID() - seatList.get(i).getSeatID() > 1){
                System.out.println(seatList.get(i).getSeatID()+1);
            }
        }
    }
}
