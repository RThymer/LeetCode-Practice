/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class _70_Climbing_Stairs {

    /**
     *
     * @param n 有n个台阶
     * @return 有多少种方法可以爬到最后一级
     *
     * 维护一个数组，每个位置的元素代表从开始到当前阶有多少种方法
     * 重要的是状态转移方程 对于每个台阶来说，要么是从后一级到当前这级；要么是从后两级跳到当前这一级
     * 所以当前这级到可用方式是后一级的方式数加上后两级的方式数
     * 状态转移方程是 f(n) = f(n - 1) + f(n - 2)
     * 其实就是斐波那契数列
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 2;

        for (int index = 3; index < n + 1; ++index) {
            ways[index] = ways[index - 1] + ways[index - 2];
        }

        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(new _70_Climbing_Stairs().climbStairs(1));
        System.out.println(new _70_Climbing_Stairs().climbStairs(5));
    }
}
