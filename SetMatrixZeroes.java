public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean[][] isZero = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0) isZero[i][j] = true;

        for (int i = 0; i < isZero.length; i++)
            for (int j = 0; j < isZero[0].length; j++)
                if(isZero[i][j]){
                    setZero(matrix, i, j);
                }

    }

    private void setZero(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) matrix[i][col] = 0;
        for (int j = 0; j < matrix[0].length; j++) matrix[row][j] = 0;
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        boolean firstRowZero = false, firstColZero = false;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i != 0 && j != 0 && matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                } else if (matrix[i][j] == 0){

                    firstRowZero = i == 0 ? true : firstRowZero;
                    firstColZero = j == 0 ? true : firstColZero;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; firstColZero && i < matrix.length; i++){
            matrix[i][0] = 0;
        }

        for(int j = 0; firstRowZero && j < matrix[0].length; j++){
            matrix[0][j] = 0;
        }
    }
}

class SetMatrixZeroesTest{
    public static void main(String[] args) {
        new Solution().setZeroes(new int[][] {{1,0,1},{1,1,1},{0,1,1}});
    }
}