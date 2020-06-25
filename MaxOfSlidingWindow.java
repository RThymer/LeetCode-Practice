import java.util.TreeMap;

public class MaxOfSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] maxSlidingWindow = new int[nums.length - k + 1];

        for (int i = 0; i < k; ++i) {
            Integer count = map.get(nums[i]);
            map.put(nums[i], count == null ? 1 : count + 1);
            maxSlidingWindow[0] = map.lastKey();
        }

        for (int i = k; i < nums.length; ++i) {
            Integer count1 = map.get(nums[i]);
            map.put(nums[i], count1 == null ? 1 : count1 + 1);
            Integer count2 = map.get(nums[i - k]);
            if (count2 == 1) map.remove(nums[i - k]);
            else map.put(nums[i - k], count2 - 1);
            maxSlidingWindow[i - k + 1] = map.lastKey();
        }
        return maxSlidingWindow;
    }

    public static void main(String[] args) {
        int[] a = new MaxOfSlidingWindow().maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4);
        System.out.println(1);
    }
}
