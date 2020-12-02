def findNumbers(numbers):
    for firstNumber in numbers:
        for secondNumber in numbers:
            if firstNumber + secondNumber == 2020:
                return firstNumber*secondNumber

file = open("codes.txt","r")
lines = file.readlines()
numbers = []
for line in lines:
    numbers.append(int(line))
print(findNumbers(numbers))
