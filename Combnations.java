import java.util.ArrayList;
import java.util.List;

public class Combnations {
    public List<List<Integer>> combine(int n, int k) {

        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        deepSearch(n, k,1, comb, result);
        return result;
    }

    private void deepSearch(int n, int k, int curPos, List<Integer> comb, List<List<Integer>> result) {
        if(comb.size() == k) {
            result.add(new ArrayList<>(comb));
        }
        else {
            for (int numIndex = curPos; numIndex <= n; numIndex++) {
                comb.add(numIndex);
                deepSearch(n, k,numIndex + 1, comb, result);
                comb.remove(comb.size() - 1);
            }
        }
    }
}

class CombnationsTest{
    public static void main(String[] args) {
        System.out.println(new Combnations().combine(4,2));
    }
}