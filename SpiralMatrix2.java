public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        boolean[][] visited = new boolean[n][n];

        int i = 0, j = 0, curVal = 1;
        while(i >= 0 && i < n && j >= 0 && j < n) {
            result[i][j] = curVal++;
            visited[i][j] = true;
            if(j < n - 1 && !visited[i][j + 1]){
                j++;
                //visited[i][j] = true;
            }
            else if(i < n - 1 && !visited[i + 1][j]){
                i++;
                //visited[i][j] = true;
            }
            else if(j > 0 && !visited[i][j - 1]){
                j--;
                //visited[i][j] = true;
            }
            else if(i > 0 && !visited[i - 1][j]){
                while (!visited[i - 1][j]) {
                    i--;
                    if(!visited[i - 1][j])
                        result[i][j] = curVal++;
                        visited[i][j] = true;
                }

                //visited[i][j] = true;
            }
            else break;
        }
        return result;

    }
}

class SpiralMatrix2Test{
    public static void main(String[] args) {
        System.out.println(new SpiralMatrix2().generateMatrix(4));
    }
}
