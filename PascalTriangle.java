import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;

        List<Integer> firstRow = new ArrayList<>(), secondRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        if(numRows == 1) return result;

        secondRow.add(1);
        secondRow.add(1);
        result.add(secondRow);
        if(numRows == 2) return result;

        for(int row = 3; row <= numRows; row++) {
            List<Integer> aRow = new ArrayList<>();
            aRow.add(1);
            for(int rowIndex = 1; rowIndex <= row - 2; rowIndex++) {
                aRow.add(result.get(row - 2).get(rowIndex) + result.get(row - 2).get(rowIndex - 1));
            }
            aRow.add(1);
            result.add(aRow);
        }

        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if(rowIndex < 1) return result;

        int[] row = new int[rowIndex + 1];
        for(int index = 0; index <= rowIndex; index++) {
            if(index == 0) row[0] = 1;
            else {
                for(int pos = rowIndex; pos > 0; pos--) {
                    row[pos] = row[pos] +row[pos - 1];
                }
            }
        }
        for (int i : row) {
            result.add(i);
        }

        return result;
    }
}

class PascalTriangleTest{
    public static void main(String[] args) {
        new PascalTriangle().getRow(5);
    }
}
