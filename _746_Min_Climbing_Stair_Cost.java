import java.util.Arrays;

public class _746_Min_Climbing_Stair_Cost {

    public int minCostClimbingStairs(int[] cost) {

        int[] costWithTop = Arrays.copyOf(cost, cost.length + 1);
        costWithTop[costWithTop.length - 1] = 0;
        int[] leastCosts = new int[costWithTop.length];

        leastCosts[0] = costWithTop[0];
        leastCosts[1] = costWithTop[1];
        for (int index = 2; index < costWithTop.length; index++) {
            leastCosts[index] = Math.min(
                    costWithTop[index] + leastCosts[index - 1],
                    costWithTop[index] + leastCosts[index - 2]
            );
        }

        return leastCosts[leastCosts.length - 1];
    }

    public static void main(String[] args) {

        int[] costs = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(new _746_Min_Climbing_Stair_Cost().minCostClimbingStairs(costs));
    }
}
