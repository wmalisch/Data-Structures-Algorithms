/**
 * Number of islands on a 2D array algorithm. Islands consist of 1's that are connected vertically or horizontally
 *
 * @author Will Malisch
 */
public class NumOfIslands {

    /**
     * Print board function
     * @param board
     */
    public static void printBoard(char[][] board){
        System.out.println(" _ _ _ _ _");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(j == board[i].length - 1){
                    System.out.printf("|%c|\n",board[i][j]);
                }else{
                    System.out.printf("|%c",board[i][j]);
                }
            }
        }
        System.out.println(" _ _ _ _ _");
    }

    /**
     * Recursively call depthIslandSearch to keep checking on all the values around its current call, converting and 1's to 0's
     * @param grid
     * @param r
     * @param c
     */
    public static void depthIslandSearch(char[][] grid, int r, int c){
        int rows = grid.length;
        int cols = grid[0].length;
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';
        depthIslandSearch(grid,r+1,c);
        depthIslandSearch(grid, r, c+1);
        depthIslandSearch(grid, r-1,c);
        depthIslandSearch(grid, r, c-1);

    }

    /**
     * Number of islands algorithm using depth first search
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid){
        int islandCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(grid[row][col] == '1'){
                    islandCount++;
                    depthIslandSearch(grid, row, col);
                }
            }
        }
        return islandCount;
    }

    public static void main(String[] args){
        char[][] mapOne = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] mapTwo = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        printBoard(mapTwo);
        System.out.println(numIslands(mapOne));
    }
}
