import java.util.Scanner;


public class TicTacToe 
{
    private final int BOARDSIZE = 3;
    private char[][] board;
    private boolean firstPlayer;
    private boolean gameOver;

    private enum Status 
    {
        WIN, DRAW, CONTINUE
    }

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
        firstPlayer = true;
        gameOver = false;
    }

    public void play()
    {
        Scanner scan = new Scanner(System.in);
        printBoard();

    }


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

    private void printStatus()
    {
        if (firstPlayer = true)
        {
            System.out.println("Player X's turn.");
        }
        else
        {
            System.out.println("Player O's turn.");
        }
    }

    private boolean validMove(int row, int col)
    {
        if (row < 0 || col < 0 || row > 2 || col > 2)
        {
            System.out.println("Invalid move");
            return false;
        }
        else if (board[row][col] != ' ')
        {
            System.out.println("Invalid move");
            return false;
        }
        else
        {
            return true;
        }
    }

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

    public static void main(String[] args) 
    {
       TicTacToe game = new TicTacToe();
       game.play(); 
    }
}