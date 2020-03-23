import java.util.Scanner;

public class MineSweeper {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int boardWidth;
        int boardHeight;
        int mines;
        do {
            System.out.print("Input Board Width: ");
            boardWidth = scn.nextInt();
            System.out.print("Input Board Height: ");
            boardHeight = scn.nextInt();
            System.out.print("Input quantity of mines: ");
            mines = scn.nextInt();
            if (boardHeight <= 0 || boardWidth <= 0 || mines <= 0
                    || mines > boardHeight * boardWidth) {
                System.out.println("Input again !");
            }
        } while (boardHeight <= 0 || boardWidth <= 0 || mines <= 0
                || mines > boardHeight * boardWidth);

        char[][] board = new char[boardHeight + 2][boardWidth + 2];
        int temp = 0;
        while (temp < mines) {
            int randomRow = (int) (Math.random() * boardHeight) + 1;
            int randomCol = (int) (Math.random() * boardWidth) + 1;
            board[randomRow][randomCol] = '*';
            temp = 0;
            for (int i = 1; i <= boardHeight; i++) {
                for (int j = 1; j <= boardWidth; j++) {
                    if (board[i][j] == '*') temp++;
                }
            }
        }
        System.out.println("Mines Map : ");
        for (int i = 1; i <= boardHeight; i++) {
            for (int j = 1; j <= boardWidth; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= boardHeight; i++) {
            for (int j = 1; j <= boardWidth; j++) {
                int count = 0;
                if(board[i][j]=='*')continue;
                if (board[i - 1][j - 1] == '*') {
                    count++;
                }
                if (board[i - 1][j] == '*') {
                    count++;
                }
                if (board[i - 1][j + 1] == '*') {
                    count++;
                }
                if (board[i][j + 1] == '*') {
                    count++;
                }
                if (board[i + 1][j + 1] == '*') {
                    count++;
                }
                if (board[i + 1][j] == '*') {
                    count++;
                }
                if (board[i + 1][j - 1] == '*') {
                    count++;
                }
                if (board[i][j - 1] == '*') {
                    count++;
                }
                board[i][j] =(char)(count+'0');
                count=0;
            }
        }

        System.out.println("Board Game "+boardHeight+" x "+boardWidth);
        for (int i = 1; i <= boardHeight; i++) {
            for (int j = 1; j <= boardWidth; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

