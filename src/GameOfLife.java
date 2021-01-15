public class GameOfLife {

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


    /**
     * Game of life algorithm for the game of life designed by John Conway to display cellular automaton
     * @param state
     */
    public static void game_of_life(int[][] state){

        // This is used to iterate around the selected cell when counting live neighbours from the main for loop
        int[] neighbours = {0,1,-1};

        int rows = state.length;
        int cols = state[0].length;
        int[][] old_state = new int[rows][cols];

        // Create a copy of state to old_state
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                old_state[i][j] = state[i][j];
            }
        }

        // Iterate through each cell in 2D array, 1 by 1, checking the amount of live neighbours, and updating the new state array based on the rules
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){

                int live_neighbours = 0;

                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){

                        if(!(neighbours[i] == 0 && neighbours[j] == 0)){
                            int r = row + neighbours[i];
                            int c = col + neighbours[j];

                            if(r < rows && r >=0 && c < cols && c >= 0 && old_state[r][c] == 1){
                                live_neighbours++;
                            }
                        }
                    }
                }

                if(old_state[row][col] == 0){
                    state[row][col] = (live_neighbours == 3) ? 1 : 0;
                }else{
                    state[row][col] = (live_neighbours < 2 || live_neighbours > 3) ? 0 : 1;
                }

            }
        }
    }

    public static void main(String[] args){
        int[][] board = new int[4][3];
        board[0][1] = 1;
        board[1][2] = 1;
        board[2][0] = 1;
        board[2][1] = 1;
        board[2][2] = 1;
        print_board(board);
        game_of_life(board);
        print_board(board);

    }
}
