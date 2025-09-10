import java.util.Scanner;


public class TicTacToe 
{
    private final int BOARDSIZE = 3;
    private char[][] board;
    private boolean firstPlayer = true;
    private boolean gameOver = false;

    private enum Status 
    {
        WIN, DRAW, CONTINUE
    }

    /*
     * class constructor 
     * Set board size and set all cells to blank ' '
     */
    public TicTacToe()
    {
        board = new char[BOARDSIZE][BOARDSIZE];
        for (int i = 0; i<3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    /*
     * Executing all functions in class TicTacToe.
     * Recieve user input.
     */
    public void play()
    {
        Scanner scan = new Scanner(System.in);
        printBoard();

        int row = -1; int col = -1;

        while (true) {
        try {
            printStatus();
            System.out.printf("Enter row number (0, 1 or 2 ): ");
            row = scan.nextInt();        

            System.out.printf("Enter column (0, 1, or 2): ");
            col = scan.nextInt();

            if (this.validMove(row, col)) {
                if (this.firstPlayer) {
                    board[row][col] = 'X';
                    this.firstPlayer = !this.firstPlayer;
                } else {
                    board[row][col] = 'O';
                    this.firstPlayer = !this.firstPlayer;
                }
            }
            this.printBoard();
            if(this.gameStatus() == Status.WIN || this.gameStatus() == Status.DRAW) {
                if(this.firstPlayer) {
                System.out.println("Player O wins.\n");
                break;
                }
                else 
                {
                    System.out.println("Player X wins.\n");
                break;
                }
            } else if ( this.gameStatus() == Status.DRAW) {
                System.out.println("Draw!");
            }
            this.printStatus();
        } catch (Exception e) {
            System.out.println("Error: Invalid Move. " + e.getMessage());
        }

        }

    }

    /*
     * Displays grid and input from users 
     */

    public void printBoard()
    {
        System.out.print(" _______________________\n|       |       |       |\n");
        for (int i = 0; i < 3; i++)
        {
            System.out.print("|   "+ board[0][i] +"   ");
        }
        System.out.print("|\n");
        System.out.print("|_______|_______|_______|\n");
        System.out.print("|       |       |       |\n");
        for (int i = 0; i < 3; i++)
        {
            System.out.printf("|   " + board[1][i] + "   ");
        }
        System.out.print("|\n");
        System.out.print("|_______|_______|_______|\n");
        System.out.print("|       |       |       |\n");
        for (int i = 0; i < 3; i++)
        {
            System.out.printf("|   " + board[2][i] + "   ");
        }
        System.out.print("|\n");
        System.out.print("|_______|_______|_______|\n");
    }

    /*
     * Checks and prints the turn of player
     */
    private void printStatus()
    {
        if (this.firstPlayer)
        {
            System.out.println("Player X's turn.");
        }
        else
        {
            System.out.println("Player O's turn.");
        }
    }


    /*
     * Check if input is within the valid parameters
     */
    private boolean validMove(int row, int col) throws Exception
    {
        if (row < 0 || col < 0 || row > 2 || col > 2)
        {
            throw new Exception("Input is too high or too low");
  
        }
        else if (board[row][col] != ' ')
        {
            throw new Exception("Space is already filled");

        }
        return true;
    }


    /*
     * Compares rows and columns to check for any win scenarios 
     */
    private Status gameStatus()
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2])
            {
                return Status.WIN;
            }
        }

        for (int i = 0; i < 3; i++)
        {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i])
            {
                return Status.WIN;
            }
        }

        
         if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2])
        {
            return Status.WIN;
        }
         if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0])
        {
            return Status.WIN;
        }

        for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                if(board[i][j] == ' ')
                {
                    return Status.CONTINUE;
                }
            }
        }
        return Status.DRAW;
    }

    /*
     * Main will be creating object and calling the functinon play()
     */
    public static void main(String[] args) 
    {
       TicTacToe game = new TicTacToe();
       game.play(); 
    }
}
