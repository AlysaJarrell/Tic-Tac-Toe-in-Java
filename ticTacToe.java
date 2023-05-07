//A Java program to demonstrate the use of functions,
// loops, conditionals, and variables in a familiar game;
// Tic-Tac-Toe
    // The game has two players 'X' and 'O' who take turns 
    // selecting an area to place their marker. 
    // The first one to get three in-a-row wins.


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ticTacToe {

    // initialize board and turn to be used throughout program
    static String[] board;
    static String turn;

    
    // To print out and populate the board, 
    //it should look like this:
    /*
	| 1 | 2 | 3 |
    |---+---+---|
	| 4 | 5 | 6 |
    |---+---+---|
	| 7 | 8 | 9 |
     */
    static void populateBoard()
    {   System.out.println("");
        System.out.println("| " + board[0] + " | " + board[1] + " | " +board[2] + " |");
        System.out.println("|---+---+---|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " +board[5] + " |");
        System.out.println("|---+---+---|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " +board[8] + " |");
        System.out.println("");

    } //end populateBoard()
    
    /*checkWin will check to see if there is a winner 
    by checking the different winning combinations rows, 
    columns, and diagonals using the board index
    */
    static String checkWin()
    {
        for (int x = 0; x < 8; x++){
            String line = null;

            switch (x) {
            case 0: //checks top row
                line = board[0] + board[1] + board[2];
                break;
            case 1: //checks middle row
                line = board[3] + board[4] + board[5];
                break;
            case 2: //checks bottom row
                line = board[6] + board[7] + board[8];
                break;
            case 3: //checks left column
                line = board[0] + board[3] + board[6];
                break;
            case 4: //checks middle column
                line = board[1] + board[4] + board[7];
                break;
            case 5: //checks right column
                line = board[2] + board[5] + board[8];
                break;
            case 6: // checks top left diagonal to bottom right
                line = board[0] + board[4] + board[8];
                break;
            case 7: //checks top right diagonal to bottom left
                line = board[2] + board[4] + board[6];
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "Congrats X you are the winner!";
            }
            
            // For O winner
            else if (line.equals("OOO")) {
                return "Congrats O, you are the winner!";
            }
        }

        for (int x = 0; x < 9; x++) {
            if (Arrays.asList(board).contains(String.valueOf(x + 1))){
                    break;
                }
                // nobody won
            else if (x == 8){
                return "draw";
            }
        }
        
	// To enter the X Or O at the exact place on board.
		System.out.println( "It's " + turn + "'s turn; Enter a number to claim it's spot: ");
		return null;
    } //end checkWin()
    

// runs the game
    public static void main(String[] args)
    {
        Scanner here = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int x = 0; x < 9; x++) {
            board[x] = String.valueOf(x + 1);
        }

        System.out.println("Tic-Tac-Toe");
        populateBoard();

        System.out.println("X will start, Enter a number to claim it's spot: ");

        while (winner == null) {
            int play;

            // exception handling
            // Makes sure that the input given was a number between 1 & 9.
            // If not it will show the given error
            try{
                play = here.nextInt();
                if (!(play > 0 && play <= 9)) {
                    System.out.println("Invaild input, please enter a number to claim it's spot:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invaild input, please enter a number to claim its spot:");
                continue;
            }

            // Determine who's turn it is.
            if (board[play - 1].equals(String.valueOf(play))) {
            board[play - 1] = turn;

                // this checks which player's turn it was last
                //  and reassigns it to be the other player's turn
                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                populateBoard();
                winner = checkWin();
            }
            else {
                System.out.println("Sorry, that spot is already taken, choose again: ");
            }
        }

        // Shows end of game, whether a 'draw' 
        // (all spots are taken but no one had three in-a-row)
        // or declares the winner
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("Looks like there was a draw, better luck next time.");
        }
        else {
            System.out.println(winner);
        }
    here.close();

    } //end main()

}
