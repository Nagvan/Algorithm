package graph;

public class NumberOfIsland {
    public static void main(String[] args) {
        int[][] island = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        int islandCount = countIsland(island);
        System.out.println("Number of island is: " + islandCount);
    }

    /**
     * Function to count the total numbers of islands in matrix
     * Time complexity O(row x col)
     * Space complexity O(row x col)
     * @param island matrix
     * @return total number of islands in matrix
     */
    private static int countIsland(int[][] island) {
        int row = island.length;
        int col = island[0].length;
        int islandCount = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                /*
                   if the point is land (1) and not visited before, a new island has been found
                 */
                if (island[i][j] == 1 && !visited[i][j]) {
                    /*
                       traverse all the land connecting to this point and mark them visited, DFS
                       At this point it seems like this will make it worse than O(row x col),
                       but once the lands are visited by DFS, they wont be visited by outer loop and condition
                       so time complexity remains O(row x col).
                     */
                    graphDfs(island, i, j, row, col, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    /**
     * DFS traversal of a graph
     * traverse each and every point on matrix
     * for every point do DFS
     * Time complexity O(row x col) -> recursive DFS can cover the entire matrix (when all the points are 1)
     * space complexity O(1)
     * @param island matrix of islands
     * @param currentRow current point row on matrix
     * @param currentCol current point col on matrix
     * @param row total number of row in matrix
     * @param col total number of col in matrix
     * @param visited a matrix to track if the current position has been visited before
     */
    private static void graphDfs(int[][] island, int currentRow, int currentCol, int row, int col, boolean[][] visited) {
        visited[currentRow][currentCol] = true;
        //This correspond to 8 neighbour of the point, i.e. (x-1, y-1), (x-1, y).... to (x+1, y), (x+1, y+1)
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        /*for every 8 neighbour corner (x-1, y-1), (x-1, y).... to (x+1, y), (x+1, y+1)
          check if the point is part of isLand
          if yes, then add that inland (visited = true) and do recursion for that new point. (DFS)
         */
        for (int k = 0; k < 8; k++) {
            if (isPartOfIsland(island, currentRow + rowNbr[k], currentCol + colNbr[k], row, col, visited)) {
                graphDfs(island, currentRow + rowNbr[k], currentCol + colNbr[k], row, col, visited);
            }
        }
    }

    /**
     * Validate if the current point is in the matrix and also part of the island
     * Time complexity O(1)
     * space complexity O(1)
     * @param island island matrix
     * @param currentRow current row on the matrix
     * @param currentCol current col on the matrix
     * @param row total number of row in the matrix
     * @param col total number of col in the matrix
     * @param visited additional matrix to track if the point on matrix has been visited before
     * @return true if the point is withing boundary, and is land (1) and not visited before
     */
    private static boolean isPartOfIsland(int[][] island, int currentRow, int currentCol, int row, int col, boolean[][] visited) {
        return currentRow >= 0 && currentRow < row && currentCol >= 0 && currentCol < col
                && island[currentRow][currentCol] == 1
                && !visited[currentRow][currentCol];
    }
}
