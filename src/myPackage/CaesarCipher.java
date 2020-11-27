package myPackage;
import java.util.*;
import java.util.Scanner;

public class CaesarCipher {
    /*In cryptography, a Caesar cipher, also known as Caesar’s cipher, the shift cipher,
    Caesar’s code or Caesar shift, is one of the simplest and most widely known encryption techniques.
    It is a type of substitution cipher in which each letter in the plaintext
    is replaced by a letter some fixed number of positions down the alphabet.
    For example, with a left shift of 3, D would be replaced by A, E would become B, and so on.
    The method is named after Julius Caesar, who used it in his private correspondence.*/

    public static StringBuffer encrypt(String text, int key){

        // creating new instance of StringBuffer
        StringBuffer ciphered = new StringBuffer();


        for (int i = 0; i < text.length(); i++){

            // case of uppercase
            if (Character.isUpperCase(text.charAt(i))){

                // different calculations are required for uppercase letters.
                // convert first to int, process the ASCII then convert back to char
                char c = (char)(((int)text.charAt(i) + (key - 65)) % 26 + 65);

                // append the new character that has been ciphered into the new StringBuffer
                ciphered.append(c);
            }

            // case of lowercase
            if (Character.isLowerCase(text.charAt(i))){

                // different calculations are required for lowercase letters.
                // convert first to int, process the ASCII then convert back to char
                char c = (char)(((int)text.charAt(i) + key - 97) % 26 +97);

                // append the new character that has been ciphered into the new StringBuffer
                ciphered.append(c);
            }


        }
        // return the ciphered text as return value for this method
        return ciphered;
    }

    public static void main(String[] args){
        // main driver code
        System.out.println("====================================");
        System.out.println("Welcome to the Caesar Cipher program");
        System.out.println("   Cipher programmed by Kelbimon");
        System.out.println("====================================");
        System.out.println();

        // get user input for string
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String to be chipered:  ");
        // store to variable
        String text = input.nextLine();

        System.out.println("====================================");
        System.out.println("");

        // get user input for key
        Scanner keyInput = new Scanner(System.in);
        System.out.print("Enter a key to cipher the string  ");
        // store to variable
        int key = keyInput.nextInt();

        // call out the cipher method and print out the ciphered text
        System.out.println("====================================");
        System.out.println("Your ciphered text is:  " + encrypt(text, key));
        System.out.println("Thank you for your patronage.");

    }
}

