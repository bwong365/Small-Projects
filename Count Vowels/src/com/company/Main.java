package com.company;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    enum Vowel {
        A(0),
        E(1),
        I(2),
        O(3),
        U(4);

        private int value;

        Vowel(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    public static void main(String[] args) {
        // array will hold our vowel counts
        int[] aeiou;
        Scanner scanner = new Scanner(System.in);

        // get a string from the user
        System.out.println("Enter a string, and I shall count the vowels!");
        System.out.print("String: ");
        String phrase = scanner.nextLine();

        // get the number of vowels
        aeiou = vowelFinder(phrase);

        // print out our counts
        countPrinter(aeiou);

    }

     private static int[] vowelFinder(String word) {
        // create an array for our vowel counts
        int[] aeiou = new int[5];

        // remove case-sensitivity
        word = word.toLowerCase();

        // iterate through the string, counting the individual vowels
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'a':
                    aeiou[Vowel.A.getValue()]++;
                    break;
                case 'e':
                    aeiou[Vowel.E.getValue()]++;
                    break;
                case 'i':
                    aeiou[Vowel.I.getValue()]++;
                    break;
                case 'o':
                    aeiou[Vowel.O.getValue()]++;
                    break;
                case 'u':
                    aeiou[Vowel.U.getValue()]++;
                    break;
            }
        }

        // returns an array of our vowel counts
        return aeiou;
    }

    private static void countPrinter(int[] aeiou) {
        // we could've used a Map, but I wanted to use an array for now
        char[] names = {'a', 'e', 'i', 'o', 'u'};

        // iterate through aeiou and print the counts if above 0
        for (int i = 0; i < aeiou.length; i++) {
            if (aeiou[i] > 0) {
                System.out.println(names[i] + ": " + aeiou[i]);
            }
        }
    }
}
