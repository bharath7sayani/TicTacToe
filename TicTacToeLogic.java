 public class TicTacToeLogic {
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;

    public TicTacToeLogic() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && col >= 0 && row < 3 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
            }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void setGameEnded(boolean state) {
        this.gameEnded = state;
    }

    /**
     * Prints the current state of the game board to the console.
     */
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    /**
     * Main method to demonstrate the game logic.
     * This simulates a simple game of Tic-Tac-Toe.
     */
    public static void main(String[] args) {
        TicTacToeLogic game = new TicTacToeLogic();
        
        System.out.println("Welcome to Tic-Tac-Toe!");
        game.printBoard();
        
        // Simulating a simple game flow
        System.out.println("Player " + game.getCurrentPlayer() + " makes a move at (0, 0)");
        game.placeMark(0, 0); // X places a mark
        game.switchPlayer();
        game.printBoard();
        
        System.out.println("Player " + game.getCurrentPlayer() + " makes a move at (1, 1)");
        game.placeMark(1, 1); // O places a mark
        game.switchPlayer();
        game.printBoard();
        
        System.out.println("Player " + game.getCurrentPlayer() + " makes a move at (0, 1)");
        game.placeMark(0, 1); // X places a mark
        game.switchPlayer();
        game.printBoard();
        
        System.out.println("Player " + game.getCurrentPlayer() + " makes a move at (1, 0)");
        game.placeMark(1, 0); // O places a mark
        game.switchPlayer();
        game.printBoard();
        
        System.out.println("Player " + game.getCurrentPlayer() + " makes a move at (0, 2)");
        game.placeMark(0, 2); // X wins
        game.printBoard();
        
        if (game.checkWin()) {
            System.out.println("Player " + game.getCurrentPlayer() + " wins!");
        } else if (game.isBoardFull()) {
            System.out.println("It's a draw!");
        }
    }
}