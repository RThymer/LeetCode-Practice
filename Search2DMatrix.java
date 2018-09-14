public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] matrixInRow = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int[] row : matrix) {
            for (int col : row){
                matrixInRow[index++] = col;
            }
        }
        int location = binarySearch(matrixInRow, target);
        return matrixInRow[location] == target;
    }

    private int binarySearch(int[] array, int target) {
        int left = 0, right = array.length;
        int mid = (left + right) / 2;
        while(left < right - 1) {
            if (array[mid] == target) return mid;
            else if (array[mid] > target){
                right = mid;
            } else {
                left = mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }
}

class Search2DMatrixTest{
    public static void main(String[] args) {
       //int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
       int[][] matrix = {{}};
       System.out.println(new Search2DMatrix().searchMatrix(matrix, 17));
    }
}