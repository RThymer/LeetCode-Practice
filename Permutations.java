import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        //元素可能重复
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> curList = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        subSequence(nums, 0, curList, visited, results);

        return results;
    }

    private void subSequence(int[] nums, int index, List<Integer> curList,
                             boolean[] visited, List<List<Integer>> results) {

        if (index == nums.length) {
            if (!results.contains(curList)) {
                List<Integer> addResult = new ArrayList<>(curList);
                results.add(addResult);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curList.add(nums[i]);
                subSequence(nums, index + 1, curList, visited, results);
                curList.remove(curList.size() - 1);
                visited[i] = false;
            }
        }
    }
}

class PermutationTest {
    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
