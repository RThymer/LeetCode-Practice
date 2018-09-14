import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        for (int pos1 = 0; pos1 < nums.length - 2; pos1++){
            int pos2 = pos1 + 1, pos3 = nums.length - 1;
            while(pos2 < pos3){
                int sum = nums[pos1] + nums[pos2] + nums[pos3];
                if(sum > 0){
                    pos3--;
                    while(pos2 < pos3 && nums[pos3] == nums[pos3 + 1]) pos3--;
                }
                else if(sum < 0){
                    pos2++;
                    while(pos2 < pos3 && nums[pos2] == nums[pos2 - 1]) pos2++;
                }
                else{
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[pos1]);
                    result.add(nums[pos3]);
                    result.add(nums[pos2]);
                    if(!results.contains(result)) results.add(result);
                    pos2++;
                    pos3--;
                    while(pos2 < pos3 && nums[pos3] == nums[pos3 + 1]) pos3--;
                    while(pos2 < pos3 && nums[pos2] == nums[pos2 - 1]) pos2++;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] testString = {-7,2,1,10,9,-10,-5,4,13,-9,-4,6,11,-12,-6,-9,-6,-9,-11,-4,10,10,-3,-1,-4,-7,-12,-15,11,5,14,11,-7,-8,6,9,-2,9,-10,-12,-15,2,10,4,5,11,10,6,-13,6,-13,12,-7,-9,-12,4,-9,13,-4,10,4,-12,6,4,-5,-10,-2,0,14,4,4,6,13,-9,-5,-5,-13,12,-14,11,3,10,8,11,-13,4,-8,-7,2,4,10,13,7,2,2,9,-1,8,-5,-10,-3,6,3,-5,12,6,-3,6,3,-2,2,14,-7,-13,10,-13,-2,-12,-4,8,-1,13,6,-9,0,-14,-15,6,9};
        System.out.println(threeSum(testString));
    }
}
