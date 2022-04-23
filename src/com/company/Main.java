package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void puzzleGame(){
        Scanner input = new Scanner(System.in);
        int final_score;

        /** Variable Level 1 **/
        int level =1;
        ArrayList<String> listOfAnswer_1 = new ArrayList<>();
        listOfAnswer_1.add("die");
        listOfAnswer_1.add("led");
        listOfAnswer_1.add("lei");
        listOfAnswer_1.add("let");
        listOfAnswer_1.add("lid");
        listOfAnswer_1.add("lie");
        listOfAnswer_1.add("lit");
        listOfAnswer_1.add("tie");
        listOfAnswer_1.add("deli");
        listOfAnswer_1.add("diet");
        listOfAnswer_1.add("edit");
        listOfAnswer_1.add("idle");
        listOfAnswer_1.add("lied");
        listOfAnswer_1.add("tide");
        listOfAnswer_1.add("tied");
        listOfAnswer_1.add("tile");
        listOfAnswer_1.add("tilt");
        listOfAnswer_1.add("tilde");
        listOfAnswer_1.add("tiled");
        listOfAnswer_1.add("title");
        listOfAnswer_1.add("titled");
        listOfAnswer_1.add("titled");

        /** Variable level 2 **/

        /** variable Level 3 **/

        System.out.println("Coepoe Word Puzzle");
        System.out.println("===================");
        System.out.println("Rules :");
        System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters.");
        System.out.println("2. Each Level, you have 10 chance to answer correctly.");
        System.out.println("3. To get through to next level, you have to score 70 points each level.");

        // level 1
        final_score = game(level, listOfAnswer_1);
        if(final_score >= 70){ // 70 passed

            //masuk level 2
            level = level+1;
            int skor_lv_2 = game(level, listOfAnswer_1);
            final_score=final_score+skor_lv_2;
            if(final_score >= 140){ // minamal level 1+ minimal level 2 = passed

                //level 3
                level = level+1;
                int score_lv_3 = game(level, listOfAnswer_1);
                final_score = final_score +score_lv_3;
                    if(final_score >= 210){ // minimal level 3 + minimal level 2 + minimal level 1 = 210, sehinggal level 3 = 70 aja udah passed
                        System.out.println("Overall Score = "+final_score);
                        System.out.println("You Win !!");
                    }else{
                         System.out.println("Do you want to retry [y/t]?");
                         String ulang = input.nextLine();
                         if (ulang.equalsIgnoreCase("y")){
                             puzzleGame();
                         }else{
                             System.out.println("Game End");
                         }
                    }
            }else{
                //balik ke level 1
                level=level-1;
                game(level, listOfAnswer_1);
            }
        }else{
            //balik ke level 1
            game(level, listOfAnswer_1);
        }
    }
    public static int game(int level, ArrayList<String> listOfAnswer){
        int countScore = 0;

        System.out.println("=== level "+level+" ===");
        System.out.println("  d   e   t   t   l   i  ");
        Scanner input = new Scanner(System.in);
        try{
                ArrayList<String> poolAnswer = new ArrayList<>();

                int correctAnswer = 0;

            for(int j=0; j < 10; j++){
                    String inputJawaban = input.nextLine();
                    int number = j+1;
                    System.out.println(number +"> Your answer : " + inputJawaban);
                    boolean contains = listOfAnswer.contains(inputJawaban);
                    if(poolAnswer.contains(inputJawaban)){
                        System.out.println("You had already type this word before...");
                    }else if(contains){
                        countScore += 10;
                        System.out.println("#Right. Score : " + countScore);
                        poolAnswer.add(inputJawaban);
                        correctAnswer++;
                    }
                }
            if(correctAnswer < 7) {
                throw new ArithmeticException("You lose try!! Try again... \nYou had answered 10 times with "+ correctAnswer +" right answers..");
            }else{
                System.out.println("You had answered 10 times with " + correctAnswer + " right answers...");
                return countScore;
            }
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            System.out.println("Do you want to retry [y/t]?");
            String ulang = input.nextLine();
            if (ulang.equalsIgnoreCase("y")) puzzleGame();
        }
        return countScore;
    }
    public static void main(String[] args) {

        puzzleGame();
    }
}
