import java.util.Random;

public class GameLogic {

    private char[][] board;
    private char currentPlayer;
    private Random random;

    public GameLogic() {

        board = new char[3][3];
        random = new Random();
        resetBoard();

    }

    public void resetBoard() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                board[i][j] = ' ';

            }

        }

        currentPlayer = 'X';

    }

    public char getCurrentPlayer() {

        return currentPlayer;

    }

    public boolean makeMove(int row, int col) {

        if (board[row][col] != ' ') {

            return false;

        }

        board[row][col] = currentPlayer;

        currentPlayer = 'O';

        return true;

    }

    public boolean computerMove() {

        if (currentPlayer != 'O') {

            return false;

        }

        if (isBoardFull()) {

            return false;

        }

        while (true) {

            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if (board[row][col] == ' ') {

                board[row][col] = 'O';

                currentPlayer = 'X';

                return true;

            }

        }

    }

    public char getCell(int row, int col) {

        return board[row][col];

    }

    public boolean checkWinner(char player) {

        for (int i = 0; i < 3; i++) {

            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player) {

                return true;

            }

        }

        for (int i = 0; i < 3; i++) {

            if (board[0][i] == player &&
                    board[1][i] == player &&
                    board[2][i] == player) {

                return true;

            }

        }

        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) {

            return true;

        }

        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player) {

            return true;

        }

        return false;

    }

    public boolean isBoardFull() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {

                    return false;

                }

            }

        }

        return true;

    }

}