public class MaxProductionSubArray {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        double[] maxPositive = new double[length];
        double[] maxNegative = new double[length];
        maxPositive[0] = maxNegative[0] = nums[0];

        double max = nums[0];
        for (int index = 1; index < length; ++index) {
            maxPositive[index] = Math.max(Math.max(
                    maxNegative[index - 1] * nums[index],
                    maxPositive[index - 1] * nums[index]),
                    nums[index]);
            maxNegative[index] = Math.min(Math.min(
                    maxNegative[index - 1] * nums[index],
                    maxPositive[index - 1] * nums[index]),
                    nums[index]);
            if (maxPositive[index] > max) max = maxPositive[index];
        }
        return (int) max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductionSubArray().maxProduct(new int[]{2, 3, -2, 4}));
    }
}
