package myPackage;
import java.util.Random;

public class GameOfLife {
    private static Integer[][] board;

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
        for (int i=0;i<filledBoard.length; i++) {
            for (int j=0; j < filledBoard[i].length; j++){
                System.out.print(filledBoard[i][j] + " ");
        }
            System.out.println();
        }
    }

    /*public int neighbourCount(int col, int row) {

        int neighbourCounter = 0;

        //find all serouding cell by adding +/- 1 to col and row
        for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {

            for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {

                //if not the center cell
                if(! ((colNum == col) && (rowNum == row))) {

                    //make sure it is within  grid
                    if(withinBoard (colNum, rowNum)) {
                        System.out.println("Neighbor of "+ col+ " "+ row + " - " + colNum +" " + rowNum );
                        neighbourCounter++;
                    }
                }
            }
        }


    }

     */

    public static int neighborCount(int row, int col) {

        int count = 0;
        for(int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < board.length) // fixed here
                for(int j = col - 1; j <= col + 1; j++)
                    if (j >= 0 && j < board[i].length) // fixed here
                        if (i != row || j != col)
                            if (board[i][j] == 1)
                                count++;
        }

        return count;
    }


    // main function
    public static void main(String[] args){
        // main driver code

        // creating empty world
       board = create_empty_world(2, 2);

        // fill board
        board = fill_world(board);

        // print out world
        print_world(board);


        int count;
        for (int i = 0; i < board.length; i++){

            for (int j = 0; j < board[i].length; j++){
                Integer[] row = board[i];

                count = neighborCount(i, j);
                System.out.print(count);
            }
        }






    }


}
