import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rows = matrix.length;

        if(rows == 0) return result;

        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int i = 0, j = 0;
        while(i >= 0 && i < rows && j >= 0 && j < cols) {
            result.add(matrix[i][j]);
            visited[i][j] = true;
            if(j < cols - 1 && !visited[i][j + 1]){
                j++;
                //visited[i][j] = true;
            }
            else if(i < rows - 1 && !visited[i + 1][j]){
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
                    if(!visited[i - 1][j])result.add(matrix[i][j]);
                    visited[i][j] = true;
                }

                //visited[i][j] = true;
            }
            else break;
        }

        return result;
    }

}

class SpiralMatrixTest{
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12},{13,14,15,16}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
