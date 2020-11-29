package myPackage;
import java.util.Random;

public class GameOfLife {

    /*John Conway’s game of Life is a type of cellular automata that demonstrates
    how simple rules can lead to
    complex patterns or behaviors

    In Life, the “world” is simulated on a large, two-dimensional grid, with each cell in the grid either empty or
    occupied by an “organism.” In the course of a turn, the contents of each cell are determined by looking at
    the eight cells surrounding it. In the basic game, an organism in one cell will be born, or live, or die,
    according to the following rules:

    1. A live cell with < 2 neighbors will die (due to under population).
    2. A live cell 2-3 neighbors lives on to the next generation.
    3. A live cell with > 3 neighbors dies (due to overpopulation).
    4. An empty cell with 3 neighbors becomes a live cell (from reproduction).*/


    // creating an empty board for base of game with user defined parameters
    public static String[][] create_empty_world(int width, int length){
        String[][] emptyBoard = new String[width][length];
        return emptyBoard;
    }
    public static String[][] fill_world(String[][] emptyBoard){
        // function takes in empty board and fills it with random values for cells

        // creating random class to randomize board values
        Random rand = new Random();

        // first for loop iterates over row
        for (int i = 0; i < emptyBoard.length; i++){

            // second for loop iterates over collumn
            for (int j = 0; j < emptyBoard[i].length; j++){
                // filling board with random values of integers converted to string
                emptyBoard[i][j] = Integer.toString(rand.nextInt(2));
            }
        }
        return emptyBoard;
    }

    public static void print_world(String[][] filledBoard){
        //display output
        for (int i=0;i<filledBoard.length; i++) {
            for (int j=0; j < filledBoard[i].length; j++){
                System.out.print(filledBoard[i][j] + " ");
        }
            System.out.println();
        }
    }


    // main function
    public static void main(String[] args){
        // main driver code

        // creating empty world
        String[][] board = create_empty_world(5, 5);

        // fill board
        board = fill_world(board);

        // print out world
        print_world(board);


    }


}
