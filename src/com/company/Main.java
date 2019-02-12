package com.company;

import java.util.Scanner;

public class Main {

    /***********************************************************************************/
    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Market");


        String input = "nothing";  // declare variables
        String item;

        double[] priceList = new double[10]; // array collection for checkout
        String[] nameList = new String[10]; // price list for checkout
        int j = 0;
        for (int i = 0; i < 10; i++) // fills both arrays with non NULL values.
        {
            priceList[i] = 0.0;
            nameList[i] = "nothing";

        }
        String currencyFrom = "nothing";
        String currencyTo = "nothing";
        Scanner keyboard = new Scanner(System.in); // initialize scanner

        while (!input.equals("6")) { // main menu

            System.out.println("Please select an option, 6 to checkout"); // outputs menu
            System.out.println("Please remember, no more than 10 items per cart");
            System.out.println("1 for Food");
            System.out.println("2 for Drinks");
            System.out.println("3 to view cart");
            System.out.println("4 for currency exchanger");
            System.out.println("5 for tab payment");
            input = keyboard.next();
/****************************************************************************/
            switch (input) { // checks input
                case "1":
                    item = foodMenu(); // call to foodMenu method
                    nameList[j] = item;

                    if (!item.equals("nothing")) { // error checks for no input
                        priceList[j] = foodCost(item);
                    }
                    if (priceList[j] == 0.0) { // if no input, fix price input
                        nameList[j] = "nothing";
                    }
                    j++; // increments array to next item slot
                    break;
                /****************************************************************************/

                case "2":
                    item = drinkMenu();  // call to drinkMenu method

                    if (item.equals("nothing")) { // error checks for no input
                        System.out.println("Youve selected nothing, returning to main menu");
                    } else {
                        nameList[j] = item;
                        priceList[j] = drinkCost(item);
                        j++; // increments array to next item slot
                    }
                    break;
                /****************************************************************************/
                case "3":
                    viewItems(nameList, priceList); // prints out items and prices selected with tax applied
                    break;
/****************************************************************************/
                case "4": // currency exchange menu
                    currencyFrom = currencyEFrom(); // gets currency to convert from
                    currencyTo = currencyETo();      // gets currency to convert to
                    if (!currencyFrom.equals("nothing") && (!currencyTo.equals("nothing"))) { // checks for no input
                        if (currencyFrom.equals(currencyTo)) {
                            System.out.println("You have selected the same two currencies!"); // error catch for same input
                        } else {
                            currencyConverted(currencyFrom, currencyTo); // converts and outputs correct currency
                        }
                    }
                    break;
/****************************************************************************/
                case "5":
                    tabPayment();
                    break;

                case "6": // case 5 so no error catch on exiting

                    break;
/****************************************************************************/
                default: // error catch for non accepted input
                    System.out.println("Please enter an actual input");
            } // end of switch
        } // while closes
        /****************************************************************************/
        System.out.println("Check Out");
        viewItems(nameList, priceList); // views items in cart
        checkOut(priceList); // calls checkout function
    } // main B 1

    /***********************************************************************************/
    public static String foodMenu() {
        Scanner keyboard = new Scanner(System.in);

        String input = "nothing"; // declares temp values
        String item = "nothing";

        System.out.println("Please select an option, 6 to return"); // food menu
        System.out.println("All items 5.75 + 18% tax");
        System.out.println("#1 for Smoked Ham Club");
        System.out.println("#2 for Italian Club");
        System.out.println("#3 for BLT Club");
        System.out.println("#4 for Tuna Club");
        System.out.println("#5 for Turkey Club");
        System.out.println("#6 to return");

        input = keyboard.next();

        switch (input) { // checks input
            case "1":
                item = "Smoked Ham Club";
                break;

            case "2":
                item = "Italian Club";
                break;

            case "3":
                item = "BLT Club";
                break;

            case "4":
                item = "Tuna Club";
                break;

            case "5":
                item = "Turkey Club";
                break;

            case "6":
                item = "nothing";
                break;

            default: // error catch returns to main menu
                System.out.println("nothing selected, returning to main menu");
        } // end of switch
        return item;
    } // end of foodMenu

    /***********************************************************************************/
    public static Double foodCost(String item) { // asks for combo or normal applies price and tax

        Scanner keyboard = new Scanner(System.in);

        String input = "0"; // declares temp variables
        Double price = 0.0;
        System.out.println("you have selected " + item + " Please select an option to continue");
        System.out.println("#1 " + item + " 5.75$ + 1.03$ tax");
        System.out.println("#2 " + item + " with chips combo: 7.75$ + 1.39$ tax");
        System.out.println("#3 to return");

        input = keyboard.next();

        switch (input) {  // checks input, sets price = to price plus tax
            case "1":
                price = 6.785;
                break;

            case "2":
                price = 9.145;
                break;

            case "3":
                price = 0.0;
                break;

            default:
                System.out.println("Error selected, returning to main menu"); // NULL input catch
                price = 0.0;
        } // end of switch
        return price;
    } // end of foodCost

    /***********************************************************************************/
    public static String drinkMenu() {
        Scanner keyboard = new Scanner(System.in);

        String input = "nothing"; // declare temp variable
        String item = "test";

        System.out.println("Please select an option #7 to return"); // print menu
        System.out.println("All non-alcoholic items subject to 18% tax");
        System.out.println("#1 Small Soda: 1.25 + 0.23$ tax");
        System.out.println("#2 Medium Soda: 1.75$ + .32$ tax");
        System.out.println("#3 Large Soda: 2.25 + .41 tax$");
        System.out.println("#4 Small Alcoholic Beverage: 2.25");
        System.out.println("#5 medium Alcoholic Beverage: 3.25");
        System.out.println("#6 large Alcoholic Beverage: 4.25");

        input = keyboard.next();

        switch (input) { // checks input
            case "1":
                item = "Small Soda";
                break;

            case "2":
                item = "Medium Soda";
                break;

            case "3":
                item = "Large Soda";
                break;
            case "4":
                item = "Small Alcoholic Beverage";
                break;
            case "5":
                item = "medium Alcoholic Beverage";
                break;
            case "6":
                item = "large Alcoholic Beverage";
                break;

            default:
                System.out.println("nothing selected, returning to main menu"); // error catch
                item = "nothing";
        } // end of switch
        return item;
    } // end of drinkMenu
    /***********************************************************************************/
    public static Double drinkCost(String item) {
        Double price = 0.0;

        switch (item) { // applies price and tax
            case "Small Soda":
                price = 1.48;
                break;

            case "Medium Soda":
                price = 2.07;
                break;

            case "Large Soda":
                price = 2.66;
                break;

            case "Small Alcoholic Beverage":
                price = 2.25;
                break;

            case "medium Alcoholic Beverage":
                price = 3.25;
                break;

            case "large Alcoholic Beverage":
                price = 4.25;
                break;

            default:
                System.out.println("Error selected, returning to main menu");
                price = 0.0;
        } // end of switch
        return price;
    } // end of drinkCost

    /***********************************************************************************/
    private static void viewItems(String nameList[], double priceList[]) {

        double total = 0.0;

        for (int i = 0; i < 10; i++) { // outputs items in list adds combo if combo option is slected
            if (!nameList[i].equals("nothing")) {
                System.out.print("#" + (i + 1) + " " + nameList[i] + " ");
                if (priceList[i] == 9.145) {
                    System.out.print("Combo ");
                }
                System.out.print(priceList[i]);
                System.out.println("$");
            }
        }
    } // end of viewitems

    /***********************************************************************************/
    public static void checkOut(double priceList[]) { // checkout function
        Scanner keyboard = new Scanner(System.in);

        double total = 0.0;
        for (int i = 0; i < 10; i++) {
            total += priceList[i];
        }

        double tax = (total * .09);
        if (total == 0) {
            System.out.println("You have nothing in your cart!");
        }

        if (total > 0.00) {
            double payment = 0.00;
            double conversion = 0.00;
            String input = "0";

            System.out.print("You owe Miller's Deli ");
            System.out.println("A total 9% tax will be added to the total bill");
            System.out.print(String.format("%.2f", (total)) + "$" + " + " + String.format("%.2f", (tax)) + "$ " + "tax "); // prints tax and adds tax to total
            total = total + tax;

            System.out.println("Please select your method of payment"); // accepted currencies list

            displayCurrencies();
            input = keyboard.next();
            while (total > 0.00) {

                switch (input) { // switch cases for each type of currency input
                    case "0":
                        System.out.println("Please enter the amount you will pay:");
                        payment = keyboard.nextDouble();
                        break;

                    case "1":
                        System.out.println("Please enter the amount you will pay:");
                        payment = keyboard.nextDouble();
                        payment = payment / 0.9813;
                        break;

                    case "2":
                        System.out.println("Please enter the amount you will pay:");
                        payment = keyboard.nextDouble();
                        payment = payment / 0.757;
                        break;

                    case "3":
                        System.out.println("Please enter the amount you will pay:");
                        payment = keyboard.nextDouble();
                        payment = payment / 52.53;
                        break;

                    case "4":
                        System.out.println("Please enter the amount you will pay:");
                        payment = keyboard.nextDouble();
                        payment = payment / 80.92;
                        break;

                    case "5":
                        System.out.println("Please enter the amount you will pay:");
                        payment = keyboard.nextDouble();
                        payment = payment / 13.1544;
                        break;

                    case "6":
                        System.out.println("Please enter the amount you will pay:");
                        payment = keyboard.nextDouble();
                        payment = payment / 0.6178;
                        break;

                    case "-1": // reprints accepted currencies
                        displayCurrencies();
                        break;

                    default:

                        System.out.println("Error selected, please select an actual option");

                } // end of switch

                if (payment <= 0) {
                    System.out.println("you have either entered 0 or a negative value");
                    payment = 0;
                }

                total = total - payment; // recalculates total - payment if payment is less than total, repeats loop
                if (total > 0.0) {
                    System.out.print("You still owe ");
                    System.out.println(String.format("%.2f", (total)));

                    System.out.println("Please select your method of payment or input -1 to view the acceptable currencies again");
                    input = keyboard.next();
                }

            } // end of while

            System.out.print("thank you for your order, your change is ");
            System.out.print(String.format("%.2f", (total * -1)));
            System.out.println("$");
        }

    } // end of checkOut
    /***********************************************************************************/
    public static String currencyEFrom() { // currency menu to convert from

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please select the currency you want to convert from"); // accepted currencies list
        displayCurrencies();

        String input = keyboard.next();
        String currencyFrom = "nothing";

        switch (input) { // switch cases for each type of currency input
            case "0":
                currencyFrom = "US Dollar";
                break;

            case "1":
                currencyFrom = "Canadian Dollar";
                break;

            case "2":
                currencyFrom = "Euro";
                break;

            case "3":
                currencyFrom = "Indian Rupee";
                break;

            case "4":
                currencyFrom = "Japanese Yen";
                break;

            case "5":
                currencyFrom = "Mexican Peso";
                break;

            case "6":
                currencyFrom = "British Pound";
                break;

            default:

                System.out.println("Error selected, returning to main menu");
                currencyFrom = "nothing";

        } // end of switch

        return currencyFrom;
    } // end of currency exchange

    /***********************************************************************************/
    public static String currencyETo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please select the currency you want to convert to"); // accepted currencies list
        displayCurrencies();

        String input = keyboard.next();
        String currencyTo = "nothing";

        switch (input) { // switch cases for each type of currency input
            case "0":
                currencyTo = "US Dollar";
                break;

            case "1":
                currencyTo = "Canadian Dollar";
                break;

            case "2":
                currencyTo = "Euro";
                break;

            case "3":
                currencyTo = "Indian Rupee";
                break;

            case "4":
                currencyTo = "Japanese Yen";
                break;

            case "5":
                currencyTo = "Mexican Peso";
                break;

            case "6":
                currencyTo = "British Pound";
                break;

            default:

                System.out.println("Error selected, returning to main menu");
                currencyTo = "nothing";

        } // end of switch

        return currencyTo;

    } // end of currencyTo

    /***********************************************************************************/
    public static void currencyConverted(String currencyFrom, String currencyTo) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("you have selected to convert " + currencyFrom + " to " + currencyTo);
        System.out.println("Please enter how much you want to convert:");

        Double moneyIn = keyboard.nextDouble(); // money in to convert
        Double moneyOut = 0.0; // money out from converting

        if (currencyFrom.equals("US Dollar")) {

            if (currencyTo.equals("Canadian Dollar")) {
                moneyOut = moneyIn * .9813;
            }
            if (currencyTo.equals("Euro")) {
                moneyOut = moneyIn * .757;
            }
            if (currencyTo.equals("Indian Rupee")) {
                moneyOut = moneyIn * 52.52;
            }
            if (currencyTo.equals("Japanese Yen")) {
                moneyOut = moneyIn * 80.92;
            }
            if (currencyTo.equals("Mexican Peso")) {
                moneyOut = moneyIn * 13.1544;
            }
            if (currencyTo.equals("British Pound")) {
                moneyOut = moneyIn * .6178;
            }
        } // end of US Dollar to X statements
/***********************************************************************************/
        if ((currencyFrom.equals("Canadian Dollar"))) {

            if (currencyTo.equals("US Dollar")) {
                moneyOut = moneyIn / .9813;
            }
            if (currencyTo.equals("Euro")) {
                moneyOut = (moneyIn / .9813) * 0.757;
            }
            if (currencyTo.equals("Indian Rupee")) {
                moneyOut = (moneyIn / .9813) * 52.53;
            }
            if (currencyTo.equals("Japanese Yen")) {
                moneyOut = (moneyIn / .9813) * 80.92;
            }
            if (currencyTo.equals("Mexican Peso")) {
                moneyOut = (moneyIn / .9813) * 13.1544;
            }
            if (currencyTo.equals("British Pound")) {
                moneyOut = (moneyIn / .9813) * .6178;
            }
        } // end of Canadian Dollar to X statements
        /***********************************************************************************/
        if ((currencyFrom.equals("Euro"))) {

            if (currencyTo.equals("US Dollar")) {
                moneyOut = moneyIn / .757;
            }
            if (currencyTo.equals("Canadian Dollar")) {
                moneyOut = (moneyIn / .757) * 0.9813;
            }
            if (currencyTo.equals("Indian Rupee")) {
                moneyOut = (moneyIn / .757) * 52.53;
            }
            if (currencyTo.equals("Japanese Yen")) {
                moneyOut = (moneyIn / .757) * 80.92;
            }
            if (currencyTo.equals("Mexican Peso")) {
                moneyOut = (moneyIn / .757) * 13.1544;
            }
            if (currencyTo.equals("British Pound")) {
                moneyOut = (moneyIn / .757) * .6178;
            }
        } // end of Euro to X statements
        /***********************************************************************************/
        if ((currencyFrom.equals("Indian Rupee"))) {

            if (currencyTo.equals("US Dollar")) {
                moneyOut = moneyIn / 52.53;
            }
            if (currencyTo.equals("Canadian Dollar")) {
                moneyOut = (moneyIn / 52.53) * 0.9813;
            }
            if (currencyTo.equals("Euro")) {
                moneyOut = (moneyIn / 52.53) * .757;
            }
            if (currencyTo.equals("Japanese Yen")) {
                moneyOut = (moneyIn / 52.53) * 80.92;
            }
            if (currencyTo.equals("Mexican Peso")) {
                moneyOut = (moneyIn / 52.53) * 13.1544;
            }
            if (currencyTo.equals("British Pound")) {
                moneyOut = (moneyIn / 52.53) * .6178;
            }
        } // end of Indian Rupee to X statements
        /***********************************************************************************/
        if ((currencyFrom.equals("Japanese Yen"))) {

            if (currencyTo.equals("US Dollar")) {
                moneyOut = moneyIn / 80.92;
            }
            if (currencyTo.equals("Canadian Dollar")) {
                moneyOut = (moneyIn / 80.92) * 0.9813;
            }
            if (currencyTo.equals("Euro")) {
                moneyOut = (moneyIn / 80.92) * .757;
            }
            if (currencyTo.equals("Indian Rupee")) {
                moneyOut = (moneyIn / 80.92) * 52.53;
            }
            if (currencyTo.equals("Mexican Peso")) {
                moneyOut = (moneyIn / 80.92) * 13.1544;
            }
            if (currencyTo.equals("British Pound")) {
                moneyOut = (moneyIn / 80.92) * .6178;
            }
        } // end of Japanese Yen to X statements
        /***********************************************************************************/
        if ((currencyFrom.equals("Mexican Peso"))) {

            if (currencyTo.equals("US Dollar")) {
                moneyOut = moneyIn / 13.1544;
            }
            if (currencyTo.equals("Canadian Dollar")) {
                moneyOut = (moneyIn / 13.1544) * 0.9813;
            }
            if (currencyTo.equals("Euro")) {
                moneyOut = (moneyIn / 13.1544) * .757;
            }
            if (currencyTo.equals("Indian Rupee")) {
                moneyOut = (moneyIn / 13.1544) * 52.53;
            }
            if (currencyTo.equals("Japanese Yen")) {
                moneyOut = (moneyIn / 13.1544) * 80.92;
            }
            if (currencyTo.equals("British Pound")) {
                moneyOut = (moneyIn / 13.1544) * .6178;
            }
        } // end of Mexican Peso to X statements
        /***********************************************************************************/
        if ((currencyFrom.equals("British Pound"))) {

            if (currencyTo.equals("US Dollar")) {
                moneyOut = moneyIn / .6178;
            }
            if (currencyTo.equals("Canadian Dollar")) {
                moneyOut = (moneyIn / .6178) * 0.9813;
            }
            if (currencyTo.equals("Euro")) {
                moneyOut = (moneyIn / .6178) * .757;
            }
            if (currencyTo.equals("Indian Rupee")) {
                moneyOut = (moneyIn / .6179) * 52.53;
            }
            if (currencyTo.equals("Japanese Yen")) {
                moneyOut = (moneyIn / .6178) * 80.92;
            }
            if (currencyTo.equals("Mexican Peso")) {
                moneyOut = (moneyIn / .6178) * 13.1544;
            }
        } // end of British Pounnd to X statements
        /***********************************************************************************/
        System.out.println(String.format("%.2f", (moneyOut)) + "$");
    } // end of currencyConverted

    /***********************************************************************************/
    public static void displayCurrencies() {
        System.out.println("Accepted currencies");
        System.out.println("#0 for US Dollar");
        System.out.println("#1 for Canadian Dollar");
        System.out.println("#2 for Euro");
        System.out.println("#3 for indian Rupee");
        System.out.println("#4 for japanese Yen");
        System.out.println("#5 for Mexican Peso");
        System.out.println("#6 for British Pound");

    } // end of displayCurrencies

    public static void tabPayment()
    {
        Scanner keyboard = new Scanner(System.in); // initialize scanner
        System.out.println("Please note, a 9% tax to non alchoholic items and an 18% tip to the total bill will be applied ");
        System.out.println("Please input your food and non alchoholic drink total");
        double nonAlchTotal = keyboard.nextDouble();
        System.out.println("Please input your alchoholic drink total");
        double alchTotal = keyboard.nextDouble();
        double total = 0.0;
        double payment = 0.0;

        nonAlchTotal = nonAlchTotal + (nonAlchTotal * .18);
        total = (nonAlchTotal + alchTotal) +((nonAlchTotal + alchTotal) * .09);

        System.out.println("You owe " + total);
        System.out.println("please select your method of payment");
        displayCurrencies();

        if (total <=0)
        {
            System.out.println("You have 0 due or have entered a negative number");
        }
        String input = keyboard.next();
        while (total > 0.00) {

            switch (input) { // switch cases for each type of currency input
                case "0":
                    System.out.println("Please enter the amount you will pay:");
                    payment = keyboard.nextDouble();
                    break;

                case "1":
                    System.out.println("Please enter the amount you will pay:");
                    payment = keyboard.nextDouble();
                    payment = payment / 0.9813;
                    break;

                case "2":
                    System.out.println("Please enter the amount you will pay:");
                    payment = keyboard.nextDouble();
                    payment = payment / 0.757;
                    break;

                case "3":
                    System.out.println("Please enter the amount you will pay:");
                    payment = keyboard.nextDouble();
                    payment = payment / 52.53;
                    break;

                case "4":
                    System.out.println("Please enter the amount you will pay:");
                    payment = keyboard.nextDouble();
                    payment = payment / 80.92;
                    break;

                case "5":
                    System.out.println("Please enter the amount you will pay:");
                    payment = keyboard.nextDouble();
                    payment = payment / 13.1544;
                    break;

                case "6":
                    System.out.println("Please enter the amount you will pay:");
                    payment = keyboard.nextDouble();
                    payment = payment / 0.6178;
                    break;

                case "-1": // reprints accepted currencies
                    displayCurrencies();
                    break;

                default:

                    System.out.println("Error selected, returning to main menu");

            } // end of switch

            if (payment <= 0) {
                System.out.println("you have either entered 0 or a negative value");
                payment = 0;
            }

            total = total - payment; // recalculates total - payment if payment is less than total, repeats loop
            if (total > 0.0) {
                System.out.print("You still owe ");
                System.out.println(String.format("%.2f", (total)));

                System.out.println("Please select your method of payment or input -1 to view the acceptable currencies again");
                input = keyboard.next();
            }

        } // end of while

        System.out.print("thank you for your order, your change is ");
        System.out.print(String.format("%.2f", (total * -1)));
        System.out.println("$");
    } // end of tabPayment
} // main B 2