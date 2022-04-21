package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void puzzleGame(){
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Masukkan banyak angka yang mau dicetak [2-10]:");
            int inputAngka = Integer.parseInt(input.nextLine());
            ArrayList<String []> listOfAnswer = new ArrayList<>();
            // Initialize child array
            String [] answerOne = {""};
            String [] answerTwo = {""};
            String [] answerThree = {""};
            listOfAnswer.add(answerOne);
            listOfAnswer.add(answerTwo);
            listOfAnswer.add(answerThree);
            int correctAnswer1 = 0;
            int correctAnswer2 = 0;
            int correctAnswer3 = 0;
            for(int i = 0; i < listOfAnswer.size(); i++ ){
                ArrayList<String> poolAnswer = new ArrayList<>();
                int countScore = 0;
                for(int j=0; j < 10; j++){
                    String inputJawaban = input.nextLine();
                    boolean contains1 = Arrays.stream(answerOne).anyMatch(x -> x == inputJawaban);
                    boolean contains2 = Arrays.stream(answerTwo).anyMatch(x -> x == inputJawaban);
                    boolean contains3 = Arrays.stream(answerThree).anyMatch(x -> x == inputJawaban);
                    int number = j+1;
                    System.out.println(number +"> Your answer : " + inputJawaban);
                    if(i == 0 && contains1){
                        correctAnswer1 += 10;
                        System.out.println("#Right. Score : " + correctAnswer1);
                        countScore++;
                    } else if(i == 1 && contains2){
                        correctAnswer2 += 10;
                        System.out.println("#Right. Score : " + correctAnswer2);
                        countScore++;
                    } else if(i == 2 && contains3){
                        correctAnswer3 += 10;
                        System.out.println("#Right. Score : " + correctAnswer3);
                        countScore++;
                    } else if(poolAnswer.contains(inputJawaban)){
                        System.out.println("You had already type this word before...");
                        j--;
                    }
                }
                if(countScore < 7) throw new ArithmeticException("You lose try!! Try again...");
                System.out.println("You had answered 10 times with " + countScore + " right answers...");
            }
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            System.out.println("Do you want to retry [y/t]?");
            String ulang = input.nextLine();
            if (ulang.equalsIgnoreCase("y")) puzzleGame();
        }
    }
    public static void main(String[] args) {
        puzzleGame();
    }
}
