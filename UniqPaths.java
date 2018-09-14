public class UniqPaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 ||
                obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) path[i][j] = 0;
                else if (i == 0 && j == 0) path[i][j] = 1;
                else if (i == 0 && j > 0) path[i][j] = path[i][j - 1];
                else if (i > 0 && j == 0) path[i][j] = path[i - 1][j];
                else path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m-1][n-1];
    }

}

class UniqPathsTest{
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new UniqPaths().uniquePathsWithObstacles(obstacleGrid));
    }
}
