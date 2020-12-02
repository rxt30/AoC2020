public class PasswordObjects{
    private String password;
    private String characterToBeFound;
    private int lowerLimit;
    private int upperLimit;
    
    public PasswordObjects(String fileLine){
        splitString(fileLine);
    }

    private void splitString(String fileLine){
        String[] splittedLine = fileLine.split(":");
        password = splittedLine[1];
        findPasswordLimitCharacter(splittedLine[0]);
    }

    private void findPasswordLimitCharacter(String limits){
        String[] splittedLine = limits.split(" ");
        characterToBeFound = splittedLine[1];
        findNumberLimits(splittedLine[0]);
    }

    private void findNumberLimits(String numberLimits){
        String[] splittedLine = numberLimits.split("-");
        lowerLimit = Integer.parseInt(splittedLine[0]);
        upperLimit = Integer.parseInt(splittedLine[1]);
    }

    public Boolean passwordValid(){
        int requiredLetterCounter = 0;
        for(int i = 0; i < password.length();i++){
            if(password.charAt(i) == characterToBeFound.charAt(0)){
               requiredLetterCounter++; 
            }
        }
        if(lowerLimit <= requiredLetterCounter && requiredLetterCounter <= upperLimit){
            return true;
        }else{
            return false;
        }
    }

    public Boolean passwordValidPosition(){
        if(password.charAt(lowerLimit) == characterToBeFound.charAt(0) ^ password.charAt(upperLimit) == characterToBeFound.charAt(0)){
            return true;
        }else{
            return false;
        }
    }
}
