package com.company;

import java.lang.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // initialize scanner
        int points = 500; // base points
        String input = "nothing";
        int achievementValue = 2000; // points for achievement


        System.out.println("You start with 500 points, please select an option");

        displayOptions(); // call to main menu options
        input = keyboard.next();
        while (!input.equals("5")) { // "4" from input exits main menu

            switch (input) {

                case "1": // slots
                    points = slotMachine(points);

                    break;

                case "2": // dice Roll
                    points = diceRoll(points);
                    break;

                case "3": // start over
                    System.out.println("You have chosen to start you now have 500 points");
                    points = 500;

                    break;

                case "4":
                    System.out.println("You have " + points + " points!");

                    break;

                case "5": // ends while with no default catch

                    break;

                default: // default error catch

                    System.out.println("Please select an actual option");

            } // end of switch

            if (points >= achievementValue) { // checks for achievement value
                System.out.println("Congratulations, youve reached over " + achievementValue + " points!");
                achievementValue *= 2;
            }

            if (points == 0) { // if points = 0
                System.out.println("Youve lost all your points!");
                System.out.println("Do you want to end or restart?");
                System.out.println("#1 to restart");
                System.out.println("#2 to end game");
                input = keyboard.next();

                switch (input) {

                    case "1":
                        points = 500;
                        break;

                    case "2":
                        input = "5";
                        break;

                } // end of switch
            } // end of points

            if (points > 0) { // stops update read if points  = 0
                displayOptions();
                input = keyboard.next();
            }

        } // end of menu while

        System.out.println("you have finished with " + points + " points"); // end statement


    } // end of main

    public static void displayOptions() { // main menu options
        System.out.println("Please select an option");
        System.out.println("#1 to play slots");
        System.out.println("#2 to play dice roll");
        System.out.println("#3 to start over");
        System.out.println("#4 to view your points");
        System.out.println("#5 to end your game");

    } // end of display options

    public static int randNumGen(int num) { // function to return random number between 1 and num

        Random random = new Random();

        int randomNumber = 0;

        randomNumber = random.nextInt(num - 1) + 1;

        return randomNumber;
    }  // end of randNumGen

    public static int slotMachine(int points) { // slot machine main menu

        int wager = getWager(points);
        int randNum = 0;
        String[] slot = new String[3];

        while ((wager != 0) && (points > 0)) {
            for (int i = 0; i < 3; i++) {
                randNum = randNumGen(7); // call to random number generator method
                switch (randNum) {

                    case 1:
                        slot[i] = "Crimson";
                        break;

                    case 2:
                        slot[i] = "Capstone";
                        break;

                    case 3:
                        slot[i] = "Resume";
                        break;

                    case 4:
                        slot[i] = "Football";
                        break;

                    case 5:
                        slot[i] = "Computer";
                        break;

                    case 6:
                        slot[i] = "Elephant";
                        break;

                    default:

                } // end of swtich

            } // end of for loop

            System.out.println(slot[0] + " " + slot[1] + " " + slot[2]);

            if ((slot[0].equals(slot[1])) && (slot[0].equals(slot[2]))) { // if statements for variations of winning
                points += wager * 3;
                System.out.println("You've Tripled your wager!");
            } else if ((slot[0].equals(slot[1]))) {
                points += wager * 2;
                System.out.println("You've doubled your wager!");
            } else if ((slot[0].equals(slot[2]))) {
                points += wager * 2;
                System.out.println("You've doubled your wager!");
            } else if ((slot[1].equals(slot[2]))) {
                points += wager * 2;
                System.out.println("You've doubled your wager!");
            } else {
                points = points - wager;
                System.out.println("You've lost your wager!");
            }
            System.out.println("You now have " + points + " points!");

            if (points > 0) { // stops menu and returns to main if user looses all their points
                wager = getWager(points);
            }

        } // end of while

        return points;
    }  // end of slotMachine

    public static int diceRoll(int points) { // diceRoll main menu
        Scanner keyboard = new Scanner(System.in);

        int randNum = 0;
        int rollType = 0;
        int totalDiceRoll = 0;
        int specNum = 0;
        int wager = getWager(points);

        if (wager != 0) {
            rollType = diceRollType();
        }
        if (rollType == 3) {
            System.out.println("Please enter your specific number");
            specNum = keyboard.nextInt();
        }

        while ((wager != 0) && (points > 0) && (rollType !=0)) {

            randNum = randNumGen(7);
            totalDiceRoll += randNum;

            randNum = randNumGen(7);
            totalDiceRoll += randNum;

            System.out.println("Youve rolled a total of " + totalDiceRoll);

            if ((rollType == 1) && (totalDiceRoll >= 2) && (totalDiceRoll <= 5)) { // low
                wager = wager * 2;
                System.out.println("You've doubled your wager!");
            } else if ((rollType == 2) && (totalDiceRoll >= 9) && (totalDiceRoll <= 12)) { // high
                wager = wager * 2;
                System.out.println("You've doubled your wager!");
            } else if ((rollType == 3) && (totalDiceRoll == specNum)) { // specific number
                wager = wager * 3;
                System.out.println("You've tripled your wager!");
            } else {
                points = points - wager;
                System.out.println("Youve lost your points!");
            }

            System.out.println("You now have " + points + " points!");

            if (points > 0) {
                //System.out.println("TESTNUM");
                wager = getWager(points);


                if (wager != 0) {
                    rollType = diceRollType();

                    if (rollType == 3) {
                        System.out.println("Please enter your specifc wager");
                        specNum = keyboard.nextInt();
                    }
                }
            }
            totalDiceRoll = 0;

        } // end of while

        return points;
    } // end of diceRoll

    public static int diceRollType() { // second menu for diceRoll
        Scanner keyboard = new Scanner(System.in);

        String input = "nothing";
        int rollType = 0;

        System.out.println("Please select how you want to roll");
        System.out.println("#1 to roll low (2-5)");
        System.out.println("#2 to roll high (9-12)");
        System.out.println("#3 to pick a specific number");

        input = keyboard.next();

        switch (input) {

            case "1":
                rollType = 1;
                break;

            case "2":
                rollType = 2;
                break;

            case "3":
                rollType = 3;
                break;

            default:
                System.out.println("Error selected returning to main menu");
                rollType = 0;

        } // end of switch input


        return rollType;

    } // diceRollType


    public static int getWager(int points) { // getWager function used for both games
        Scanner keyboard = new Scanner(System.in);
        int wager = 0;
        String input = "nothing";
        System.out.println("Please enter how much you want to wager, you can wager up to " + points + " points");
        System.out.println("#1 to wager " + points / 5);
        System.out.println("#2 to wager " + points / 2);
        System.out.println("#3 to wager " + points);
        System.out.println("#4 to quit");
        input = keyboard.next();
        switch (input) {

            case "1": // sets wager equal to different sets of input
                wager = points / 5;
                break;

            case "2":
                wager = points / 2;
                break;

            case "3":
                wager = points;
                break;

            case "4":
                wager = 0;
                break;

            default:
                System.out.println("error selected");
                wager = 0;

        } // end of input switch


        return wager;
    } // end of getWager

} // end of class main