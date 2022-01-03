public class _198_Rob {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums 房屋的金额
     * @return 最大的打劫数量
     *
     *
     * 状态转移方程为： 当前的最大金额为
     * 1、不打劫当前，则最大金额为i-1
     * 2、打劫当前，则最大金额为当前加上i-2
     *
     * 1、2两种情况的最大值为当前位置的最大值
     *
     */
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] maxRob = new int[nums.length];
        maxRob[0] = nums[0];
        maxRob[1] = Math.max(nums[0], nums[1]);

        for (int index = 2; index < nums.length; ++index) {
            maxRob[index] = Math.max(maxRob[index - 1], maxRob[index - 2] + nums[index]);
        }


        return maxRob[maxRob.length - 1];
    }

    public static void main(String[] args) {
        int[] houseWealth  = new int[]{ 2,7,9,3,1 };
        System.out.println(new _198_Rob().rob(houseWealth));
    }
}
