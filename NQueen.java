public class NQueen {

    // if queen is safe or not
    static boolean isqueenplaceonsafearea(boolean board[][], int row, int column) {

        // check 1-checkig above row
        for (int i = row; i >= 0; i--) {
            if (board[i][column] == true) {
                return false;
            }
        }

        // check 2 left diagonal check

        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == true) {
                return false;
            }

        // check 3 right diagonal check

        for (int i = row, j = column; i >= 0 && j < board[row].length; i--, j++) {
            if (board[i][j] == true) {
                return false;
            }
        }

        return true;
    }

    static int countnumberofways(boolean board[][], int currentrow) {
        int count = 0;
        // termination case

        if (currentrow == board.length) {
            return 1;// possibilty
        }
        // from row(traverse each column)
        for (int column = 0; column < board[currentrow].length; column++) {
            if (isqueenplaceonsafearea(board, currentrow, column)) {
                board[currentrow][column] = true;

                // moving to the next row

                int result = countnumberofways(board, currentrow + 1);
                count = count + result;
                board[currentrow][column] = false;// undo the option

            }

        }
        return count;

    }

    public static void main(String[] args) {
        final int N = 1;
        boolean chessboard[][] = new boolean[N][N];

        int count = countnumberofways(chessboard, 0);
        System.out.println(count);

    }
}
//AGRIM ASWAL