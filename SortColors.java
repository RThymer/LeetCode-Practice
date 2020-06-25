public class SortColors {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index >= left && index <= right) {
            if (nums[index] == 0) {
                swap(nums, left, index);
                left++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, right, index);
                right--;
            } else {
                index++;
            }
        }
        System.out.println(nums.toString());
    }

    private void swap(int[] nums, int pos1, int pos2) {
        if ((pos1 >= 0 && pos1 < nums.length) && (pos2 >= 0 && pos2 < nums.length)) {
            int tmp = nums[pos1];
            nums[pos1] = nums[pos2];
            nums[pos2] = tmp;
        }
    }
}

class SortColorsTest {
    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{1, 2, 0});
    }
}