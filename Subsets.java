import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        deepSearch(nums,0, comb, result);
        return result;
    }

    private void deepSearch(int[] nums, int curPos, List<Integer> comb, List<List<Integer>> result) {
        List<Integer> sortedComb = new ArrayList<>(comb);
        Collections.sort(sortedComb);
        if (!result.contains(sortedComb))
            result.add(sortedComb);

        //System.out.println(comb);
        for (int index = curPos; index < nums.length; index++) {
            if (!comb.contains(nums[index])) {
                comb.add(nums[index]);
                deepSearch(nums,curPos + 1, comb, result);
                comb.remove(comb.size() - 1);
            }
        }
    }
}

class SubsetsTest{
    public static void main(String[] args) {
        int[] nums = new int[] {4,1,0};
        System.out.println(new Subsets().subsets(nums));
    }
}