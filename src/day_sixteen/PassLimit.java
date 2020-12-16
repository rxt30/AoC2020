package day_sixteen;

public class PassLimit{
    private int lowerLimit = 0,upperLimit = 0;

    public PassLimit(String currentLine){
        readLimitsFromLine(currentLine); 
    }

    private void readLimitsFromLine(String currentLine){
        String[] lineSplitted = currentLine.split("-");
        lowerLimit = Integer.parseInt(lineSplitted[0]);
        upperLimit = Integer.parseInt(lineSplitted[1]);
    }

    public Boolean checkNumber(int numberToCheck){
        Boolean numberValid = false;
        if(numberToCheck <= upperLimit && numberToCheck >= lowerLimit){
            numberValid = true;
        }
        return numberValid;
    }
}
