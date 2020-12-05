package day_five;

public class Seat{
    private int seatID = 0;
    private int highRangeRow = 127;
    private int lowRangeRow = 0;
    private int highRangeColumn = 7;
    private int lowRangeColumn = 0;

    public Seat(String boardingZone){
        calculateBoardingID(boardingZone);        
    }

    private void calculateBoardingID(String boardingZone){
        for(char currentLimiter : boardingZone.toCharArray()){
            nextRangeLimiter(currentLimiter); 
        }
        seatID = highRangeRow * 8 + highRangeColumn;
    }

    private void nextRangeLimiter(char currentLimiter){
        int rowDifference = (highRangeRow - lowRangeRow + 1) / 2;
        int columnDifference = (highRangeColumn - lowRangeColumn + 1) / 2;
        switch(currentLimiter){
            case 'F':   highRangeRow -= rowDifference;break;
            case 'B':   lowRangeRow += rowDifference;break;
            case 'L':   highRangeColumn -= columnDifference;break; 
            case 'R':   lowRangeColumn += columnDifference;break;
        }
    }

    public int getSeatID(){
        return seatID;
    }
}
