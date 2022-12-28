import java.util.Scanner;

public class Connect4Main {

    static int[][] board = new int[6][7];

    public static void main(String[] args) {
        System.out.println("Welcome to the Connect4 App!");
        System.out.println("Player 1 will be known as \"1\" and player 2 will be known as \"2\".");
        System.out.println("Type \"0\" at any time to exit the game.");
        gameLoop();
    }

    public static void gameLoop() {
        setBoard();
        printBoard();

        connect4 util = new connect4();

        Scanner scnr = new Scanner(System.in);
        int counter = 0;
        int column = 1;
        while(!(column == 0)) {
            if(counter % 2 == 0) {
                if(!playerChoice(1, scnr, board, util)) break;
            }
            else {
                if(!playerChoice(2, scnr, board, util)) break; 
            }
            int win = util.checkForWin(board);
            if(win == 1 || win == 2) {
                System.out.println("Player " + win + " won!");
                System.out.println("Play again? (Yes or anything else for No)");
                String choice = scnr.next();
                if(choice.equalsIgnoreCase("yes")) gameLoop();
                else {
                    System.out.println("Thanks for playing!");
                    System.exit(1);
                }
            }

            printBoard();
            counter++;
        }
        scnr.close();
    }

    public static void setBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public static void printBoard() {
        for(int[] row : board) {
            for(int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println("X X X X X X X");
        System.out.println("1 2 3 4 5 6 7");
    }

    public static boolean playerChoice(int player, Scanner scnr, int[][] board, connect4 util) {
        System.out.print("Player " + player + " Move: ");
        int column = scnr.nextInt();
        if(column == 0) return false;
        while((column > 7) || (column < 1)) {
            System.out.println("Please enter a valid number (1-7): ");
            column = scnr.nextInt();
        }
        while(!util.play(player, column, board)) {
            System.out.println("Column full! Choose another column: ");
            column = scnr.nextInt();
        }
        return true;
    }
}
