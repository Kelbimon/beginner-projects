package myPackage;
import java.util.*;


public class Pyramid {

    /* This is a program that will print half of a pyramid.
    * It takes the user's entered height as input.
    * #
    * ##
    * ###
    * ####
    * #####
    * Sample pyramid of height 5 */

    // main class
    public static void main(String[] args) {

        // get user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter desired height ");
        // store to variable
        int n = input.nextInt();

        // nested for loop
        for(int i = 1; i < n + 1; i ++){ // first loop is for the height of pyramid

            // second loop is for the row or in this case hashes
            for(int j =0; j < i; j++){
                System.out.print('#');
            }
            // printing out EndOfLine
            System.out.println("");

        }
    }
}
