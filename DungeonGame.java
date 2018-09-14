public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] =
                dungeon[rows - 1][cols - 1] > 0 ? 1 : -dungeon[rows - 1][cols - 1] + 1;

        for(int i = rows - 2; i >=0; --i){
            dp[i][cols - 1] = Math.max(dp[i + 1][cols - 1] - dungeon[i][cols - 1], 1);
        }
        for(int i = cols - 2; i >=0; --i){
            dp[rows - 1][i] = Math.max(dp[rows - 1][i + 1] - dungeon[rows - 1][i], 1);
        }

        for(int i = rows - 2; i >= 0; --i){
            for(int j = cols - 2; j >= 0; --j){
                dp[i][j] = Math.max(1,
                        Math.min(
                                dp[i][j + 1] - dungeon[i][j], dp[i + 1][j] - dungeon[i][j]
                        )
                );
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args){
        int[][] dungeon = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(new DungeonGame().calculateMinimumHP(dungeon));
    }
}
