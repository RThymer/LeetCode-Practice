public class Search2DMatrix {
    public boolean searchMatrix2(int[][] matrix, int target) {
        //每行的元素从左到右升序排列。
        //每列的元素从上到下升序排列。
        int rowUpBound = matrix.length - 1;
        int colDownBound = 0;

        while(rowUpBound >= 0 && colDownBound < matrix[0].length){
            int cmp = matrix[rowUpBound][colDownBound];
            if(cmp == target) return true;
            else if(cmp > target) rowUpBound--;
            else colDownBound++;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //每行中的整数从左到右按升序排列。
        //每行的第一个整数大于前一行的最后一个整数。
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

    public static void main(String[] args) {
        //int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        int[][] matrix = {{}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix, 17));
    }
}