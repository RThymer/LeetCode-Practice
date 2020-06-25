import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSets2 {
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        deepSearch(nums, 0, visited, comb, result);
        return result;
    }

    private void deepSearch(int[] nums, int curPos, boolean[] visited, List<Integer> comb, List<List<Integer>> result) {
        List<Integer> sortedComb = new ArrayList<>(comb);
        Collections.sort(sortedComb);
        if (!result.contains(sortedComb))
            result.add(sortedComb);

        //System.out.println(comb);
        for (int index = curPos; index < nums.length; index++) {
            if (!visited[index]) {
                visited[index] = true;
                comb.add(nums[index]);
                deepSearch(nums, curPos + 1, visited, comb, result);
                comb.remove(comb.size() - 1);
                visited[index] = false;
            }
        }
    }
}

class SubSets2Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(new SubSets2().subsets(nums));
    }
}
