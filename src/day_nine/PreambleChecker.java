package day_nine;

import aocUtils.FileReader;
import java.util.*;

public class PreambleChecker{
        private Vector<String> fileContent;

        public static void main(String[] args){
            PreambleChecker main = new PreambleChecker();
            main.startProcess();
        }

        private void startProcess(){
            FileReader fileReader = new FileReader("files/ports.txt");
            fileContent = fileReader.readFile();
            long invalidNumber = findInvalidNumber();
            findContigousSet(invalidNumber);
        }

        private long findInvalidNumber(){
            int lineCounter = 25;
            long currentNumber = 0;
            for(;lineCounter < fileContent.size();lineCounter++){
               currentNumber = Integer.parseInt(fileContent.get(lineCounter));
               if(checkNumber(currentNumber,lineCounter) == false) break;
            }
            System.out.println("Wrong Number " + currentNumber);
            System.out.println("Wrong Line " + lineCounter);;
            return currentNumber;
        }

        private Boolean checkNumber(long currentNumber, int currentLine){
            int firstNumber = 0, secondNumber = 0;
            for(int i = currentLine - 25; i < currentLine - 1;i++){
                firstNumber = Integer.parseInt(fileContent.get(i));
                for(int j = i + 1; j < currentLine;j++){
                    secondNumber = Integer.parseInt(fileContent.get(j));
                    if(firstNumber + secondNumber == currentNumber) return true;
                }
            }
            return false;
        }

        private void findContigousSet(long invalidNumber){
            int startLine = 0;
            ArrayList<Long> numberRange = new ArrayList<Long>();
            long currentLineNumber = 0, currentRangeSum = 0;
            for(int i = 0; i < fileContent.size();i++){
                currentLineNumber = Long.parseLong(fileContent.get(i));
                numberRange.add(currentLineNumber);
                currentRangeSum = calculateRangeSum(numberRange);
                if(currentRangeSum == invalidNumber){
                    break;
                }else if(currentRangeSum > invalidNumber){
                    startLine++;
                    i = startLine;
                    numberRange.clear();
                }
            }
            Collections.sort(numberRange);
            long finalNumber = numberRange.get(0) + numberRange.get(numberRange.size()-1);
            System.out.println(finalNumber);

        }

        private long calculateRangeSum(ArrayList<Long> numberRange){
            long sum = 0;
            for(Long currentNumber : numberRange){
                sum += currentNumber;
            }
            return sum;
        }
}
