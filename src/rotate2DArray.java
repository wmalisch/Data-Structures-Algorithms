public class rotate2DArray {

    public static void print_board(int[][] board){
        System.out.println(" _ _ _");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(j == board[i].length - 1){
                    System.out.printf("|%d|\n",board[i][j]);
                }else{
                    System.out.printf("|%d",board[i][j]);
                }
            }
        }
        System.out.println(" _ _ _");
    }



    public static void rotate2DArrayLeft(int[][] board){
        if(board.length != board[0].length) {
            System.out.println("Must use a square shaped array");
        }
        int n = board.length;

        // Iteration through all rings
        for(int i = 0; i < n / 2; i++){

            // Iterations through current ring
            for(int j = i; j < n - i - 1; j++){

                int store = board[i][j];

                board[i][j] = board[j][n - 1 - i];

                board[j][n - 1 - i] = board[n - 1 - i][n - 1- j];

                board[n - 1 - i][n - 1 - j] = board[n - 1 - j][i];

                board[n - 1 - j][i] = store;

            }
        }

    }

    public static void main(String[] args){
        int[][] board = new int[4][4];
        board[0][1] = 1;
        board[2][0] = 1;
        board[2][1] = 1;
        board[2][2] = 1;
        board[1][1] = 1;
        print_board(board);
        rotate2DArrayLeft(board);print_board(board);

    }
}
