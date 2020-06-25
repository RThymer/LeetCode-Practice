public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) return;
        int length = nums.length;
        int middle = length - k % length;
        reverse(nums, 0, middle - 1);
        reverse(nums, middle, length - 1);
        reverse(nums, 0, length - 1);
    }

    private static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{1, 2, 3, 4, 5}, 2);
    }
}
