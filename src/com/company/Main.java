package com.company;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // alright gang, don't look at the code, its bad, but hey it works so high fives all around!

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);

        int numDogs = 0;
        int randNum;

        int dogID;
        String name;
        String breed;
        String sex;
        int age;
        int weight;

        System.out.println("how many dogs do you want on the file?");
        PrintWriter outFile = new PrintWriter("input.txt");
        numDogs = keyboard.nextInt();

        for (int i=0; i<numDogs; i++) {

            dogID = randNumGen(299999);

            randNum = randNumGen(95);
            name = getName(randNum);

            randNum = randNumGen(8);
            breed = getBreed(randNum);

            sex = getSex();

            age = randNumGen(25);
            weight = randNumGen(50);


            outFile.println(dogID + "#" + name + "#" + breed + "#" + sex + "#" + age + "#" + weight); // prints array to outfile selected


        }
        outFile.close(); // closes file
    }

    public static String getBreed(int randNum) {

        String[] nameList = {"lab","terrier","corgie","hound","boxer","husky","boxer","bulldog"};
        String breed = nameList[randNum];

        return breed;
    }

    public static String getSex() {

        int breedNum = randNumGen(3);
        String breed;
        if (breedNum == 1) {
            breed = "F";
        }
        else {
            breed = "M";
        }
        return breed;

    }

    public static String getName(int randnum) {

        String[] nameList = {"Priscila","Annie","Flo","Billy","Kori","Rosina","Laure","Nigel","Cassondra","Merlyn","Apolonia","Malinda","Lana","Brooke","Willian","Joy","Sandee","Sharron","Lizeth","Allegra","Regina","Suzanne","Candace","Tory","Britteny","Gabriela","Ileana","Debora","Alton","Mercedes","Cora","Arnold","Stephen","Kandace","Asa","Nicolette","Kimberley","Shanika","Terri","Deloras","Gregg","Williams","Santana","Kristal","Florentina","Beatriz","Elfrieda","Juliana","Micki","Glendora","Marcel","Steven","Mark","Hassie","Lean","Zina","Arnetta","Janiece","Nancee","Rima","Melodie","Jeanie","Caron","Therese","Tona","Sherika","Kenda","Cassondra","Tameka","Oma","Doug","Ambrose","Mathew","Adolfo","Janice","Bianca","Anika","Madonna","Adelina","Shella","Melisa","Delena","Diedre","Earnestine","Fransisca","Leida","Tiffaney","Bessie","Trula","Hanh","Lorena","Karren","Calandra","Mindi","Angele"};

        String name = nameList[randnum];

        return name;
    }

    public static int randNumGen(int num) { // function to return random number between 1 and num

        Random random = new Random();

        int randomNumber = 0;

        randomNumber = random.nextInt(num - 1) + 1;

        return randomNumber;
    }  // end of randNumGen

}