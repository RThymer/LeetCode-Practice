import java.util.Arrays;

public class ArrayProductExceptSelf {
    //计算数组中除自身之外的所有元素的乘积，不使用除法;
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        int mul = 1;
        //从左到右偏一位
        for (int i = 1; i < nums.length; ++i) {
            mul *= nums[i - 1];
            res[i] = mul;
        }

        mul = 1;
        //从右到左偏一位
        for (int i = nums.length - 2; i >= 0; --i) {
            mul *= nums[i + 1];
            res[i] *= mul;
        }

        return res;
    }
}
