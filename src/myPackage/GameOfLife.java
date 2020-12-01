package myPackage;
import java.util.Random;
import java.lang.*;

public class GameOfLife {


    /*John Conway’s game of Life is a type of cellular automata that demonstrates
    how simple rules can lead to complex patterns or behaviors

    In Life, the “world” is simulated on a large, two-dimensional grid, with each cell in the grid either empty or
    occupied by an “organism.” In the course of a turn, the contents of each cell are determined by looking at
    the eight cells surrounding it. In the basic game, an organism in one cell will be born, or live, or die,
    according to the following rules:

    1. A live cell with < 2 neighbors will die (due to under population).
    2. A live cell 2-3 neighbors lives on to the next generation.
    3. A live cell with > 3 neighbors dies (due to overpopulation).
    4. An empty cell with 3 neighbors becomes a live cell (from reproduction).*/


    private static Integer[][] board;

    // creating an empty board for base of game with user defined parameters
    public static Integer[][] create_empty_world(int width, int length) {

        board = new Integer[width][length];
        return board;
    }

    // function takes in empty board and fills it with random values for cells
    public static Integer[][] fill_world(Integer[][] emptyBoard){

        // creating random class to randomize board values
        Random rand = new Random();

        // first for loop iterates over row
        for (int i = 0; i < emptyBoard.length; i++){

            // second for loop iterates over collumn
            for (int j = 0; j < emptyBoard[i].length; j++){
                // filling board with random values of integers converted to string
                emptyBoard[i][j] = rand.nextInt(2);
            }
        }
        return emptyBoard;
    }

    public static void print_world(Integer[][] filledBoard){
        //display output
        for (Integer[] integers : filledBoard) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public static int neighborCount(int row, int col) {

        int count = 0;
        for(int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < board.length) // this code ensures the row does not exceed bounds
                for(int j = col - 1; j <= col + 1; j++)
                    if (j >= 0 && j < board[i].length) // collumn does not exceed bounds
                        if (i != row || j != col)
                            if (board[i][j] == 1)
                                count++;
        }

        return count;
    }

    public static boolean isCellAlive(int x, int y){
        return board[x][y] == 1;
    }

    public static void get_next_generation(){
        int count;
        for (int i = 0; i < board.length; i++){

            for (int j = 0; j < board[i].length; j++){
                count = neighborCount(i, j);
                // System.out.print(isCellAlive(i, j));

                // conditionals for determining cell future
                // if more than 3 neighbours and is an alive cell
                if (count > 3 && isCellAlive(i, j))
                    board[i][j] = 0;

                // if less than 2 neighbour and is an alive cell
                else if (count < 2 && isCellAlive(i, j))
                    board[i][j] = 0;

                // if 3 neighbours are present and is a dead cell
                else if (count == 3 && !isCellAlive(i, j))
                    board[i][j] = 1;

            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



    // main function
    public static void main(String[] args) throws InterruptedException {
        // main driver code
        int generation = 100;
        int counting = 0;
        // creating empty world
       board = create_empty_world(10, 10);

        // fill board
        board = fill_world(board);

        // print out world
        print_world(board);
        System.out.println("=================================");
        Thread.sleep(500);

        // loop world generation
        while (counting <= generation){
            get_next_generation();
            print_world(board);
            System.out.println("=================================");
            counting++;
            clearScreen();
            Thread.sleep(500);

        }














    }


}
