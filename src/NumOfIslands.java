import java.util.Queue;
import java.util.LinkedList;

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

    public static int breadthIslandSearch(char[][] grid){
        int islandCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate through each location in map
        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(grid[row][col] == '1'){
                    islandCount++;
                    grid[row][col] = '0';
                    Queue<Integer> queue = new LinkedList<>();

                    // Convert index's to one integer and add this to queue
                    queue.add(row * cols + col);
                    while(!queue.isEmpty()){

                        // Decode the indecies integer to row and columns
                        int k = queue.remove();
                        int r = k / cols;
                        int c = k % cols;

                        // Check if the location above it is in the grid and a 1
                        if( r - 1 >= 0 && grid[r-1][c] == '1'){
                            queue.add(( r - 1 ) * cols + c);
                            grid[r-1][c] = '0';
                        }
                        if( r + 1 < rows && grid[r+1][c] == '1'){
                            queue.add((r+1) * cols + c);
                            grid[r+1][c] = '0';
                        }
                        if(c - 1 >= 0 && grid[r][c-1] == '1'){
                            queue.add(r * cols + (c -1));
                            grid[r][c-1] = '0';
                        }
                        if( c + 1 < cols && grid[r][c+1] == '1'){
                            queue.add(r * cols + (c + 1));
                            grid[r][c+1] = '0';
                        }
                    }

                }
            }
        }

        return islandCount;
    }

    public static void main(String[] args){
        char[][] mapOne = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] mapTwo = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        printBoard(mapOne);
        System.out.println(breadthIslandSearch(mapOne));
    }
}
